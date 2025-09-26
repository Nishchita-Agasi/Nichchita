package javaFileNotesApp;
import java.io.*;
import java.util.Scanner;

public class NotesManager {

    // File where notes will be stored
    private static final String FILE_NAME = "notes.txt";

    // Method to write notes to the file
    public static void addNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your note (type 'exit' on a new line to finish):");

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) { // 'true' to append notes
            while (true) {
                String note = scanner.nextLine();
                if (note.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(note + System.lineSeparator()); // Write each note to file
            }
            System.out.println("Notes saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read notes from the file
    public static void viewNotes() {
        File file = new File(FILE_NAME);

        // If no file or empty
        if (!file.exists()) {
            System.out.println("No notes found! Add some notes first.");
            return;
        }

        System.out.println("\nYour Notes:");
        System.out.println("-----------");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean hasNotes = false;

            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
                hasNotes = true;
            }

            if (!hasNotes) {
                System.out.println("No notes available in the file.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Text-Based Notes Manager ===");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            // Validate input
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input! Please enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    addNote();
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    System.out.println("Exiting program... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
