package pl.ksiezak.adrian.java.project.blog.repository;

import pl.ksiezak.adrian.java.project.blog.main.JdbcConnection;
import pl.ksiezak.adrian.java.project.blog.web.model.Post;
import pl.ksiezak.adrian.java.project.blog.web.model.builder.PostBuilder;

import java.sql.*;
import java.util.List;

public class PostDao {

    public List<Post> listTryWithResources() {
        Connection connection = JdbcConnection.getJdbcConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM POST;");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String authorId = resultSet.getString("AUTHOR");
                String title = resultSet.getString("TITLE");
                String sentens = resultSet.getString("SENTENS");
                String dateOfPublication = resultSet.getString("DATEOFPUBLICATION");
                String timeFromPublication = resultSet.getString("TIMEFROMPUBLICATION");
                System.out.println("ID: " + id);
                System.out.println("AUTHOR: " + authorId);
                System.out.println("TITLE: " + title);
                System.out.println("SENTENS: " + sentens);
                System.out.println("DATEOFPUBLICATION: " + dateOfPublication);
                System.out.println("TIMEFROMPUBLICATION: " + timeFromPublication);
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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM POST ORDER BY ID;");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String authorId = resultSet.getString("AUTHOR");
                String title = resultSet.getString("TITLE");
                String sentens = resultSet.getString("SENTENS");
                String dateOfPublication = resultSet.getString("DATEOFPUBLICATION");
                String timeFromPublication = resultSet.getString("TIMEFROMPUBLICATION");
                System.out.println("ID: " + id);
                System.out.println("AUTHOR: " + authorId);
                System.out.println("TITLE: " + title);
                System.out.println("SENTENS: " + sentens);
                System.out.println("DATEOFPUBLICATION: " + dateOfPublication);
                System.out.println("TIMEFROMPUBLICATION: " + timeFromPublication);
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

    public void create(Post post) {
        Connection connection = JdbcConnection.getJdbcConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO POST (ID,AUTHOR,TITLE,SENTENS,DATEOFPUBLICATION) VALUES (?,?,?,?,?);");
            preparedStatement.setInt(1, post.getId());
            //preparedStatement.setString(2, post.getAuthorId());
            //preparedStatement.setInt(3,post.getTitle());
            preparedStatement.setString(4, post.getSentence());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Post read(int readId) {
        Connection connection = JdbcConnection.getJdbcConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT TITLE FROM POST WHERE ID = ?;");
            preparedStatement.setInt(1, readId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int authorId = resultSet.getInt("AUTHOR");
                String title = resultSet.getString("TITLE");
                String sentens = resultSet.getString("SENTENS");
                Post readPost = new PostBuilder()
                        .setId(id)
                        .setAuthorId(authorId)
                        .setTitle(title)
                        .setSentence(sentens)
                        .createPost();
                System.out.println("ID: " + id);
                System.out.println("AUTHOR: " + authorId);
                System.out.println("TITLE: " + title);
                System.out.println("SENTENS: " + sentens);
                return readPost;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(int id, String title) {
        Connection connection = JdbcConnection.getJdbcConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE POST SET ID = ?  WHERE TITLE = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, title);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Connection connection = JdbcConnection.getJdbcConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM POST WHERE ID =?;");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM POST;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
