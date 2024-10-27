package Mines.BankOOP;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private Customer customer;
    private double balance = 0;
    

    public Account(Customer customer) {
        this.customer = customer;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String formatCurrency(double amount){
        return NumberFormat.getCurrencyInstance(Locale.US).format(amount);
    }

    public void deposit(double amount) throws InvalidDepositAmountException {
        if (amount > 0){
            balance += amount;
            System.out.println("You have deposited " + formatCurrency(amount) + ".");
            System.out.println("Your account balance is " + formatCurrency(balance) + ".");
        }
        else
            throw new InvalidDepositAmountException();
        
    }

    
    public void withdraw(double amount) throws InvalidWithdrawalAmountException {
        if (amount > balance) 
            throw new InvalidWithdrawalAmountException();
        if (amount <= 0) 
            throw new InvalidWithdrawalAmountException("Withdrawal amount cannot be zero or negative.");
        
        balance -= amount;
        System.out.println("You have successfully withdrawn " + formatCurrency(amount));
        System.out.println("Your balance is " + formatCurrency(balance));

    }
            
    public void checkBalance() {
        System.out.println("Your account balance is " + formatCurrency(balance));
    }
    
    public void transfer(double amount, String name) throws InvalidTransferAmountException {
        if (amount > balance) 
            throw new InvalidTransferAmountException();
        if (amount <= 0) 
            throw new InvalidTransferAmountException();
        balance -= amount;
        System.out.println("You have successfully transferred " + formatCurrency(amount) + " to " + name + ".");
        System.out.println("Your balance is " + formatCurrency(balance));
    }

    public void changePIN(String pin) {
        customer.setPin(pin);
        System.out.println("Your PIN has been changed.");
    }

    
    
}
