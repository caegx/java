package Mines.BankOOP;

import java.time.LocalDateTime;

public class Transaction {
    private String reference;
    private LocalDateTime transactionDateTime;
    private double amount;

    public Transaction(String reference, double amount) {
        this.reference = reference;
        this.amount = amount;
        this.transactionDateTime = LocalDateTime.now();
    }

    public String getReference() {
        return reference;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public double getAmount() {
        return amount;
    }

    

    
}
