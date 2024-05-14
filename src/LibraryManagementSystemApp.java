/*
 * Phillip Yohner
 * CEN 3024C - Software Development 1
 * May 14, 2024
 * LibraryManagementSystemApp.java (main)
 * This class contains the main method that first prompts the user
 * to enter the path to their text file, then provides a menu with
 * options to add a book, remove a book, list all books, or quit.
 * When adding a book, the user will enter an ID number, title, and
 * author.  When removing a book, the user will enter the ID number.
 * */

import java.util.Scanner;

public class LibraryManagementSystemApp {

    public static void main(String[] args) {
        // Create library object
        Library library = new Library();
        // Create Scanner for user inputs
        Scanner input = new Scanner(System.in);

        // Prompt user for text file's path
        System.out.print("Enter the path to the text file containing book details: ");
        String filePath = input.nextLine();
        // Add books listed in text file to library
        library.addBookFromFile(filePath);
        library.listBooks();

        int choice;
        do {
            // Display menu options to user
            System.out.println("\nMenu:");
            System.out.println("1. Add a book manually");
            System.out.println("2. Remove a book");
            System.out.println("3. List all books");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    // Add a book
                    library.addBookManually();
                    break;
                case 2:
                    // Prompt the user to enter the ID of the book to remove
                    System.out.print("Enter the ID of the book to remove: ");
                    int bookIdToRemove = input.nextInt();
                    library.removeBook(bookIdToRemove);
                    break;
                case 3:
                    // List all books in the library
                    library.listBooks();
                    break;
                case 4:
                    // Quit the program
                    System.out.println("Exiting...");
                    break;
                default:
                    // Invalid choice message
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);
        input.close();

    }
}