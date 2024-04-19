package Compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection instance;

    private DBConnection() {}

    public static Connection getInstance() {
        if (instance == null) {
            try {
                instance = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookStore", "root", "1234");
            } catch (SQLException e) {
                throw new RuntimeException("Error connecting to the database", e);
            }
        }
        return instance;
    }
}

