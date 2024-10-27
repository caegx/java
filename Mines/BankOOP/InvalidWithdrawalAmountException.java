package Mines.BankOOP;

public class InvalidWithdrawalAmountException extends Exception {
    public InvalidWithdrawalAmountException() {
        super("Withdrawal is more than your balance.");
    }
    public InvalidWithdrawalAmountException(String message) {
        super(message);
    }
}
