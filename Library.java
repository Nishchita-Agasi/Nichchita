package librarySystem;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Add a new user to the library
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    // Display all books
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("Books in Library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Display all users
    public void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        System.out.println("Registered Users:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    // Issue a book by ID
    public void issueBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId && !book.isIssued()) {
                book.issueBook();
                System.out.println("Book issued: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not available or already issued!");
    }

    // Return a book by ID
    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId && book.isIssued()) {
                book.returnBook();
                System.out.println("Book returned: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found or not issued!");
    }
}
