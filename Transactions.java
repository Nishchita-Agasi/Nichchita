package bank_operations_simulation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transactions {
    private String type; // Deposit or Withdraw
    private double amount;
    private LocalDateTime dateTime;

    public Transactions(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "[" + dateTime.format(formatter) + "] " + type + ": " + amount;
    }
}

