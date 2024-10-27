package Mines.BankOOP;

public class InvalidDepositAmountException extends Exception {
    public InvalidDepositAmountException() {
        super("Deposit amount cannot be zero or negative.");
    }
    
}
