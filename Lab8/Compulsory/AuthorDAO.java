package Compulsory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDAO {
    private Connection connection;

    public AuthorDAO() {
        this.connection = DBConnection.getInstance();
    }

    public void addAuthor(String name, String country) throws SQLException {
        String query = "INSERT INTO Authors (name, country) VALUES (?, ?) ON DUPLICATE KEY UPDATE name=name, country=country";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, country);
            statement.executeUpdate();
        }
    }

    public void listAuthors() throws SQLException {
        String query = "SELECT * FROM Authors ORDER BY author_id";  // Added ORDER BY clause here
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("author_id") +
                        ", Name: " + resultSet.getString("name") +
                        ", Country: " + resultSet.getString("country"));
            }
        }
    }
}