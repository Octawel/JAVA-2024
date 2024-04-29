package Homework;

public class Homework {
    public static void main(String[] args) {
        AuthorDAO authorDao = new AuthorDAO();
        BookDAO bookDao = new BookDAO();

        try {
            Author author1 = new Author(0, "Test1", "USA");
            authorDao.addAuthorIfNotExists(author1);
            Author author2 = new Author(0, "Test2", "Brazil");
            authorDao.addAuthorIfNotExists(author2);

            System.out.println("Authors List:");
            authorDao.listAuthors();

            author1.setId(1);
            author2.setId(2);

            Book book1 = new Book(0, "Test1", "French", new java.sql.Date(System.currentTimeMillis()), 328, author1);
            bookDao.addBookIfNotExists(book1);
            Book book2 = new Book(0, "Test2", "Italian", new java.sql.Date(System.currentTimeMillis()), 417, author2);
            bookDao.addBookIfNotExists(book2);

            System.out.println("Books List:");
            bookDao.listBooks();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}