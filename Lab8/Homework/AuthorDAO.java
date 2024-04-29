package Homework;

import java.sql.*;

public class AuthorDAO {
    public int addAuthor(Author author) throws SQLException {
        String query = "INSERT INTO Authors (name, country) VALUES (?, ?)";
        try (Connection conn = DataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, author.getName());
            statement.setString(2, author.getCountry());
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating author failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    author.setId(generatedKeys.getInt(1));
                    return author.getId();
                } else {
                    throw new SQLException("Creating author failed, no ID obtained.");
                }
            }
        }
    }

    public void listAuthors() throws SQLException {
        String query = "SELECT * FROM Authors ORDER BY author_id";
        try (Connection conn = DataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("author_id") +
                        ", Name: " + resultSet.getString("name") +
                        ", Country: " + resultSet.getString("country"));
            }
        }
    }

    public void addAuthorIfNotExists(Author author) throws SQLException {
        String query = "SELECT COUNT(*) FROM Authors WHERE name = ? AND country = ?";
        try (Connection conn = DataSource.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(query)) {
            checkStmt.setString(1, author.getName());
            checkStmt.setString(2, author.getCountry());
            ResultSet resultSet = checkStmt.executeQuery();
            if (resultSet.next() && resultSet.getInt(1) == 0) {
                addAuthor(author);
            }
        }
    }

    public int addOrUpdateAuthor(Author author) throws SQLException {
        Integer authorId = getAuthorIdByName(author.getName());
        if (authorId != null) {
            String updateQuery = "UPDATE Authors SET country = ? WHERE author_id = ?";
            try (Connection conn = DataSource.getConnection();
                 PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                updateStmt.setString(1, author.getCountry());
                updateStmt.setInt(2, authorId);
                updateStmt.executeUpdate();
            }
            return authorId;
        } else {
            return addAuthor(author);
        }
    }

    public Integer getAuthorIdByName(String name) throws SQLException {
        String query = "SELECT author_id FROM Authors WHERE name = ?";
        try (Connection conn = DataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("author_id");
            } else {
                return null;
            }
        }
    }
}
