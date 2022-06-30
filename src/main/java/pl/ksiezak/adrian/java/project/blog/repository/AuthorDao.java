package pl.ksiezak.adrian.java.project.blog.repository;

import pl.ksiezak.adrian.java.project.blog.web.model.Author;
import pl.ksiezak.adrian.java.project.blog.main.JdbcConnection;
import pl.ksiezak.adrian.java.project.blog.web.model.builder.AuthorBuilder;

import java.sql.*;
import java.util.List;
import java.util.logging.Logger;

public class AuthorDao {

    private static final Logger LOGGER = Logger.getLogger(AuthorDao.class.getName());

    public List<Author> listTryWithResources() {
        Connection connection = JdbcConnection.getJdbcConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM AUTHOR;");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstName = resultSet.getString("FIRSTNAME");
                String lastName = resultSet.getString("LASTNAME");
                String nickName = resultSet.getString("NICKNAME");
                System.out.println("ID: " + id);
                System.out.println("FIRSTNAME: " + firstName);
                System.out.println("LASTNAME: " + lastName);
                System.out.println("NICKNAME: " + nickName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void list() {
        Connection connection = JdbcConnection.getJdbcConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM AUTHOR ORDER BY ID;");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstName = resultSet.getString("FIRSTNAME");
                String lastName = resultSet.getString("LASTNAME");
                String nickName = resultSet.getString("NICKNAME");
                System.out.println("ID: " + id);
                System.out.println("FIRSTNAME: " + firstName);
                System.out.println("LASTNAME: " + lastName);
                System.out.println("NICKNAME: " + nickName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public Author create(Author author) {
        Connection connection = JdbcConnection.getJdbcConnection();
        try {
            int generateId = DatabaseUniqueIdGenerator.generateId();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO AUTHOR (ID,FIRSTNAME,LASTNAME,NICKNAME) VALUES (?,?,?,?);");
            preparedStatement.setInt(1, generateId);
            preparedStatement.setString(2, author.getFirstName());
            preparedStatement.setString(3,author.getLastName());
            preparedStatement.setString(4, author.getNickName());
            preparedStatement.execute();

            author.setId(generateId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }

    public Author read(int readId) {
//        System.out.println("read(" + readId + ")");
        LOGGER.info("read(" + readId + ")");
        Connection connection = JdbcConnection.getJdbcConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM AUTHOR WHERE ID = ?;");
            preparedStatement.setInt(1, readId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstName = resultSet.getString("FIRSTNAME");
                String lastName = resultSet.getString("LASTNAME");
                String nickName = resultSet.getString("NICKNAME");
                Author readTest = new AuthorBuilder().setId(id).setFirstName(firstName).setLastName(lastName).setNickName(nickName).createAuthor();
//                System.out.println("ID: " + id);
//                System.out.println("FIRSTNAME: " + firstName);
//                System.out.println("LASTNAME: " + lastName);
//                System.out.println("NICKNAME: " + nickName);
//                System.out.println("read(...) = " + readTest);
                LOGGER.info("read(...) = " + readTest);
                return readTest;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Author update(int id, String lastName) {
//        System.out.println("update(" + id + ", " + lastName + ")");
        LOGGER.info("update(" + id + ", " + lastName + ")");
        Connection connection = JdbcConnection.getJdbcConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE AUTHOR SET LASTNAME=? WHERE ID=?;");
            preparedStatement.setString(1, lastName);
            preparedStatement.setInt(2, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                int idUpdate = resultSet.getInt("ID");
//                String firstNameUpdate = resultSet.getString("FIRSTNAME");
//                String lastNameUpdate = resultSet.getString("LASTNAME");
//                String nickNameUpdate = resultSet.getString("NICKNAME");
//                Author updateAuthor = new AuthorBuilder().setId(idUpdate).setFirstName(firstNameUpdate).setLastName(lastNameUpdate).setNickName(nickNameUpdate).createAuthor();
//                return updateAuthor;
//            }
            preparedStatement.executeUpdate();
            Author readAuthor = read(id);
//            System.out.println("update(...) = " + readAuthor);
            LOGGER.info("update(...) = " + readAuthor);
            return readAuthor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        Connection connection = JdbcConnection.getJdbcConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM AUTHOR WHERE ID =?;");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM AUTHOR;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
