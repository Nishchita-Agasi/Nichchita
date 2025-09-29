package bank_operations_simulation;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        int choice;

        System.out.println("Welcome to the Bank Management System!");

        do {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. List All Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    String accNumber = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double initialBalance = sc.nextDouble();
                    bank.createAccount(name, accNumber, initialBalance);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNumber = sc.nextLine();
                    System.out.print("Enter Amount to Deposit: ");
                    double depositAmount = sc.nextDouble();
                    bank.depositToAccount(accNumber, depositAmount);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNumber = sc.nextLine();
                    System.out.print("Enter Amount to Withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    bank.withdrawFromAccount(accNumber, withdrawAmount);
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accNumber = sc.nextLine();
                    bank.checkBalance(accNumber);
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    accNumber = sc.nextLine();
                    bank.viewHistory(accNumber);
                    break;

                case 6:
                    bank.listAllAccounts();
                    break;

                case 7:
                    System.out.println("Thank you for using the Bank Management System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        } while (choice != 7);

        sc.close();
    }
}

