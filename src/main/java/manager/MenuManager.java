package manager;

import db.DBConnectionProvider;
import model.BookATable;
import model.Menu;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuManager implements Manager<Menu, Integer> {

    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void create(Menu menu) {
        String query = "INSERT INTO `menu` (`name`,`description`) " +
                "VALUES(?,?);";
        try {

            PreparedStatement pStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pStatement.setString(1, menu.getName());
            pStatement.setString(2, menu.getDescription());
            pStatement.executeUpdate();
            ResultSet generatedKeys = pStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                menu.setId(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(Menu menu) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("UPDATE user SET name = '%s', description = '%s' WHERE id=" + menu.getId(),
                    menu.getName(), menu.getDescription());
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Menu> getAll() {
        String sql = "SELECT * from menu" ;
        List<Menu> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Menu menu = Menu.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .build();
                result.add(menu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }



    public void delete(Integer id) {
        String sql = "DELETE from menu where id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public Menu getById(Integer id) {
        return null;
    }


}
