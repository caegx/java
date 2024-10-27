package Exceptions;

public class InvalidAmountException extends Exception {
    public InvalidAmountException() {
        super("Deposit amount cannot be zero or negative.");
    }
}
