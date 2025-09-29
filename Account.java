package bank_operations_simulation;

import java.util.ArrayList;

public class Account {
    private String accountHolder;
    private String accountNumber;
    private double balance;
    private ArrayList<Transactions> transactions;

    // Constructor
    public Account(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add(new Transactions("Account Opened", initialBalance));
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transactions("Deposit", amount));
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be greater than 0!");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transactions("Withdraw", amount));
            System.out.println("Successfully withdrew: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Withdrawal amount must be greater than 0!");
        }
    }

    // View Balance
    public void viewBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: " + balance);
    }

    // Show Transaction History
    public void viewTransactionHistory() {
        System.out.println("\nTransaction History for Account: " + accountNumber);
        for (Transactions t : transactions) {
            System.out.println(t);
        }
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

