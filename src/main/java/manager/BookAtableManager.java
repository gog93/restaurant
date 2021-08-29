package manager;

import db.DBConnectionProvider;
import model.BookATable;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BookAtableManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private UserManager userManager = new UserManager();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public void addBookATable(BookATable bookATable) {
        String query = "INSERT INTO `book_a_table` (`number`,`date`,`user_id`) " + "VALUES(?,?,?);";
        try {

            PreparedStatement pStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pStatement.setString(1, bookATable.getNumber());
            pStatement.setString(2, sdf.format(bookATable.getDate()));
            pStatement.setInt(3, bookATable.getUser().getId());
            pStatement.executeUpdate();
            ResultSet generatedKeys = pStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                bookATable.setId(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateBook(BookATable bookATable) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("UPDATE book SET number = '%s', date = '%s' WHERE id=" + bookATable.getId(),
                    bookATable.getNumber(), bookATable.getDate());
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<BookATable> getBookATable() {
        String sql = "SELECT * from book_a_table";
        List<BookATable> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                BookATable book = BookATable.builder()
                        .id(resultSet.getInt(1))
                        .number(resultSet.getString(2))
                        .date(resultSet.getDate(3))
                        .user(userManager.getUserById(resultSet.getInt(4)))
                        .build();
                result.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public BookATable getBookAtableById(int id) {
        String sql = "SELECT * FROM book_A_Table WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return BookATable.builder()
                        .id(resultSet.getInt(1))
                        .number(resultSet.getString(2))
                        .date(resultSet.getDate(5))
                        .user(userManager.getUserById(resultSet.getInt(7)))
                        .build();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteBookATable(int id) {
        String sql = "DELETE from book_a_Table where id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}


