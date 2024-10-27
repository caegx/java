package Mines.BankOOP;

public class InvalidTransferAmountException extends Exception {
    public InvalidTransferAmountException() {
        super("Transfer amount cannot be zero or negative.");
    }

    public InvalidTransferAmountException(String message) {
        super(message);
    }
}
