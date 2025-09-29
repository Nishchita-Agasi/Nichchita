package bank_operations_simulation;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    // Create a new account
    public void createAccount(String holderName, String accountNumber, double initialBalance) {
        Account account = new Account(holderName, accountNumber, initialBalance);
        accounts.add(account);
        System.out.println("Account successfully created for " + holderName + "!");
    }

    // Find account by account number
    private Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    // Deposit
    public void depositToAccount(String accountNumber, double amount) {
        Account acc = findAccount(accountNumber);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Withdraw
    public void withdrawFromAccount(String accountNumber, double amount) {
        Account acc = findAccount(accountNumber);
        if (acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Check Balance
    public void checkBalance(String accountNumber) {
        Account acc = findAccount(accountNumber);
        if (acc != null) {
            acc.viewBalance();
        } else {
            System.out.println("Account not found!");
        }
    }

    // View Transaction History
    public void viewHistory(String accountNumber) {
        Account acc = findAccount(accountNumber);
        if (acc != null) {
            acc.viewTransactionHistory();
        } else {
            System.out.println("Account not found!");
        }
    }

    // View All Accounts
    public void listAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found!");
            return;
        }
        System.out.println("\n--- List of Accounts ---");
        for (Account acc : accounts) {
            System.out.println("Account Number: " + acc.getAccountNumber() + 
                               " | Holder: " + acc.getAccountHolder());
        }
    }
}
