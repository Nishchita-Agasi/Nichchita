package employeeJDBCapp;

//import com.example.jdbc.dao.EmployeeDAO;
//import com.example.jdbc.model.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final EmployeeDAO dao = new EmployeeDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Employee CRUD Menu ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. View Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine();
            try {
                switch (choice) {
                    case "1": addEmployee(); break;
                    case "2": viewAll(); break;
                    case "3": viewById(); break;
                    case "4": updateEmployee(); break;
                    case "5": deleteEmployee(); break;
                    case "6": System.out.println("Bye!"); return;
                    default: System.out.println("Invalid choice");
                }
            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }
        }
    }

    private static void addEmployee() throws SQLException {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Department: ");
        String dept = sc.nextLine();
        System.out.print("Salary: ");
        double sal = Double.parseDouble(sc.nextLine());
        Employee e = new Employee(name, dept, sal);
        int id = dao.addEmployee(e);
        System.out.println("Added with ID: " + id);
    }

    private static void viewAll() throws SQLException {
        List<Employee> list = dao.getAllEmployees();
        if (list.isEmpty()) System.out.println("No employees.");
        else list.forEach(System.out::println);
    }

    private static void viewById() throws SQLException {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Employee e = dao.getEmployeeById(id);
        System.out.println(e == null ? "Not found" : e);
    }

    private static void updateEmployee() throws SQLException {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Employee e = dao.getEmployeeById(id);
        if (e == null) { System.out.println("Not found."); return; }
        System.out.print("New name (" + e.getName() + "): ");
        String n = sc.nextLine(); if (!n.isEmpty()) e.setName(n);
        System.out.print("New dept (" + e.getDepartment() + "): ");
        String d = sc.nextLine(); if (!d.isEmpty()) e.setDepartment(d);
        System.out.print("New salary (" + e.getSalary() + "): ");
        String s = sc.nextLine(); if (!s.isEmpty()) e.setSalary(Double.parseDouble(s));
        System.out.println(dao.updateEmployee(e) ? "Updated!" : "Failed.");
    }

    private static void deleteEmployee() throws SQLException {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println(dao.deleteEmployee(id) ? "Deleted." : "Not found.");
    }
}
