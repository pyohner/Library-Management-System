/*
* Phillip Yohner
* CEN 3024C - Software Development 1
* May 14, 2024
* Book.java
* This class is a book with an ID, title, and author.
* */

public class Book {

    // Book ID
    private int id;
    // Book title
    private String title;
    // Book author
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
