package task2;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // Add a student
    public void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        // Check duplicate ID
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    // View all students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Update a student
    public void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new Name: ");
                String name = sc.nextLine();
                System.out.print("Enter new Marks: ");
                double marks = sc.nextDouble();

                s.setName(name);
                s.setMarks(marks);

                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Delete a student
    public void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Search a student
    public void searchStudent() {
        System.out.println("Search by:\n1. ID\n2. Name");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        switch (choice) {
            case 1:
                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();
                for (Student s : students) {
                    if (s.getId() == id) {
                        System.out.println("Record Found: " + s);
                        found = true;
                        break;
                    }
                }
                break;
            case 2:
                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();
                for (Student s : students) {
                    if (s.getName().equalsIgnoreCase(name)) {
                        System.out.println("Record Found: " + s);
                        found = true;
                    }
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }

        if (!found) {
            System.out.println("No matching record found.");
        }
    }
}

