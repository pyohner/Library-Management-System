import java.util.Scanner;

public class LibraryManagementSystemApp {

    public static void main(String[] args) {
        // Test cases
        Library library = new Library();
        library.addBookFromFile("src/books.txt");
        //library.listBooks();

        Scanner input = new Scanner(System.in);

        int choice;
        do {
            // Display menu options
            System.out.println("\nMenu:");
            System.out.println("1. Remove a book");
            System.out.println("2. List all books");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    // Prompt the user to enter the ID of the book to remove
                    System.out.print("Enter the ID of the book to remove: ");
                    int bookIdToRemove = input.nextInt();
                    library.removeBook(bookIdToRemove);
                    break;
                case 2:
                    // List all books in the library
                    library.listBooks();
                    break;
                case 3:
                    // Quit the program
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 3);

        // Close the Scanner object
        input.close();



//        System.out.print("Enter the ID of the book to remove: ");
//        int bookIdToRemove = input.nextInt();

        //library.removeBook(2);  // TEST: remove book with ID 2
        //library.removeBook(bookIdToRemove);
        //library.listBooks();
    }

}
