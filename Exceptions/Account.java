package Exceptions;


public class Account {
    private float balance;

    public void deposit(float value) throws InvalidAmountException {
        if(value <= 0)
            throw new InvalidAmountException();

    }

    public void withdraw(float amount) throws AccountException  {
        if(amount > balance)
            throw new AccountException(new InsufficientFundsException());
    }

    /* public void withdraw(float amount) throws InsufficientFundsException  {
        if(amount > balance)
            throw new InsufficientFundsException();
    } */
    
}
