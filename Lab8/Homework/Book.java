package Homework;

import java.sql.Date;

public class Book {
    private int id;
    private String title;
    private String language;
    private Date pubDate;
    private int numPages;
    private Author author;

    public Book() {
    }

    public Book(int id, String title, String language, Date pubDate, int numPages, Author author) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.pubDate = pubDate;
        this.numPages = numPages;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public int getNumPages() {
        return numPages;
    }

    public Author getAuthor() {
        return author;
    }
}