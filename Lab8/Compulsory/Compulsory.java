package Compulsory;

import java.sql.SQLException;

public class Compulsory {
    public static void main(String[] args) {
        AuthorDAO authorDao = new AuthorDAO();
        try {
            authorDao.addAuthor("George Orwell", "United Kingdom");
            authorDao.addAuthor("Gabriel Garcia Marquez", "Colombia");
            authorDao.listAuthors();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

