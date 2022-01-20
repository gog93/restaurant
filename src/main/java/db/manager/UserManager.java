package db.manager;

import db.DBConnectionProvider;
import model.User;
import model.UserType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void addUser(User user) {
        String sql = "INSERT INTO user(`name`, `surname`, `email`, `password`)" + " VALUES(?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());

            preparedStatement.executeUpdate();
            ResultSet generateedKey = preparedStatement.getGeneratedKeys();
            if (generateedKey.next()) {
                int id = generateedKey.getInt(1);
                user.setId(id);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void updateUser(User user) {
        String sql = String.format("UPDATE user SET `name`='%s', surname='%s', email='%s', password='%s',type='%s' WHERE id=" + user.getId(),
                user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), user.getUserType().name());
        List<User> userList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<User> getUsers() {
        String sql = "SELECT * FROM user";
        List<User> result = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = User.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .userType(UserType.valueOf(resultSet.getString(5)))
                        .password(resultSet.getString(6))


                        .build();
                result.add(user);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public User getUserById(int id) {
        String sql = "SELECT * FROM user WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return User.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .password(resultSet.getString(5))
                        .userType(UserType.valueOf(resultSet.getString(6)))

                        .build();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    public User getUserByPasswordAndEmail(String email, String password) {
        String sql = "SELECT * FROM user WHERE email='" + email + "'AND password='" + password + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return User.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .password(resultSet.getString(6))
                        .userType(UserType.valueOf(resultSet.getString(5)))
                        .build();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }


    public void deleteUser(int id) {
        String sql = "DELETE FROM user WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
