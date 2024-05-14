/*
 * Phillip Yohner
 * CEN 3024C - Software Development 1
 * May 14, 2024
 * Library.java
 * This class is the library that contains each book ojbect
 * and includes methods to add the list of books from a text file,
 * add a book manually, remove a book, and list all the books.
 * */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Library {

    // A List of books is created
    private List<Book> books;

    // Library constructor
    public Library() {
        this.books = new ArrayList<>();
    }

    /*
    * addBookFromFile accepts a file path and uses BufferedReader to
    * read the contents of the text file. Each line of text is split
    * into three parts, using the commas as a separater, and creates
    * a book object that is added to the books list.
    * */
    public void addBookFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String author = parts[2];
                books.add(new Book(id, title, author));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * addBookManually creates a Scanner to collect the book
    * details - ID, title, and author - from the user.
    * Then adds the book to the books list.*/
    public void addBookManually() {
        Scanner bookInput = new Scanner(System.in);
        System.out.print("Enter ID of the book: ");
        int id = bookInput.nextInt();
        bookInput.nextLine(); // Consume newline character

        System.out.print("Enter title of the book: ");
        String title = bookInput.nextLine();

        System.out.print("Enter author of the book: ");
        String author = bookInput.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully.");
    }

    /*
    * removeBook takes the bookId provided by the user. An iterator
    * is used to iterate through the books list until a matching
    * bookId is found.  Once found, the iterated book object is removed.
    * Otherwise, the user is told the book was not found. */
    public void removeBook(int bookId) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == bookId) {
                iterator.remove();
                System.out.println("Book with ID " + bookId + " removed successfully.");
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    /*
    * listBooks prints a complete list of the current book list. */
    public void listBooks() {
        System.out.println("Listing all books:");
        for (Book book : books) {
            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }
}