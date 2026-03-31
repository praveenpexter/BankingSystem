// Transaction.java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String type;      // DEPOSIT, WITHDRAW, TRANSFER
    private double amount;
    private String timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        // Record exact time of transaction
        this.timestamp = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public void display() {
        System.out.println("  [" + timestamp + "]  " + type + "  Rs." + amount);
    }
}