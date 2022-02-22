package manager;

import db.DBConnectionProvider;
import model.User;
import model.UserType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager implements Manager<User, Integer> {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void create(User user) {
        String query = "INSERT INTO `user` (`name`,`surname`,`email`,`password`) " +
                "VALUES(?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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

    public void update(User user) {
        String sql = String.format("UPDATE user SET `name`='%s', surname='%s', email='%s', password='%s',userType='%s' WHERE id=" + user.getId(),
                user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), user.getUserType().name());
        List<User> userList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }



    public List<User> getAll() {
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



    public User getById(Integer id) {
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
                        .userType(UserType.valueOf(resultSet.getString(5)))
                        .password(resultSet.getString(6))
                        .build();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    public User getByPasswordAndEmail(String email, String password) {
        String sql = "SELECT * FROM user WHERE email='" + email + "' and password = '" + password+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return User.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .userType(UserType.valueOf(resultSet.getString(5)))
                        .password(resultSet.getString(6))
                        .build();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }


    public void delete(Integer id) {
        String sql = "DELETE FROM user WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
