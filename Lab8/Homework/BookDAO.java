package Homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.*;

public class BookDAO {
    public void addBook(Book book) throws SQLException {
        String query = "INSERT INTO Books (title, language, pub_date, num_pages, author_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getLanguage());
            statement.setDate(3, new java.sql.Date(book.getPubDate().getTime()));
            statement.setInt(4, book.getNumPages());
            statement.setInt(5, book.getAuthor().getId());
            statement.executeUpdate();
        }
    }

    public void listBooks() throws SQLException {
        String query = "SELECT b.book_id, b.title, b.language, b.pub_date, b.num_pages, a.name as author_name, a.country as author_country " +
                "FROM Books b " +
                "INNER JOIN Authors a ON b.author_id = a.author_id " +
                "ORDER BY b.book_id ASC";

        try (Connection conn = DataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("book_id") +
                        ", Title: " + resultSet.getString("title") +
                        ", Language: " + resultSet.getString("language") +
                        ", Publication Date: " + resultSet.getDate("pub_date") +
                        ", Number of Pages: " + resultSet.getInt("num_pages") +
                        ", Author: " + resultSet.getString("author_name") +
                        ", Country: " + resultSet.getString("author_country"));
            }
        }
    }

    public void addBookIfNotExists(Book book) throws SQLException {
        String query = "SELECT COUNT(*) FROM Books WHERE title = ? AND author_id = ?";
        try (Connection conn = DataSource.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(query)) {
            checkStmt.setString(1, book.getTitle());
            checkStmt.setInt(2, book.getAuthor().getId());
            ResultSet resultSet = checkStmt.executeQuery();
            if (resultSet.next() && resultSet.getInt(1) == 0) {
                addBook(book);
            }
        }
    }

    public void addOrUpdateBook(Book book) throws SQLException {
        if (!authorExists(book.getAuthor().getId())) {
            System.out.println("Author ID " + book.getAuthor().getId() + " not found, cannot insert book: " + book.getTitle());
            return;
        }

        if (bookExists(book.getTitle(), book.getAuthor().getId())) {
            String updateQuery = "UPDATE Books SET language = ?, pub_date = ?, num_pages = ? WHERE title = ? AND author_id = ?";
            try (Connection conn = DataSource.getConnection();
                 PreparedStatement statement = conn.prepareStatement(updateQuery)) {
                statement.setString(1, book.getLanguage());
                statement.setDate(2, new java.sql.Date(book.getPubDate().getTime()));
                statement.setInt(3, book.getNumPages());
                statement.setString(4, book.getTitle());
                statement.setInt(5, book.getAuthor().getId());
                statement.executeUpdate();
            }
        } else {
            addBook(book);
        }
    }

    private boolean authorExists(int authorId) throws SQLException {
        String query = "SELECT COUNT(*) FROM Authors WHERE author_id = ?";
        try (Connection conn = DataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, authorId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        }
        return false;
    }


    private boolean bookExists(String title, int authorId) throws SQLException {
        String query = "SELECT COUNT(*) FROM Books WHERE title = ? AND author_id = ?";
        try (Connection conn = DataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, title);
            statement.setInt(2, authorId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                return true;
            }
        }
        return false;
    }
}