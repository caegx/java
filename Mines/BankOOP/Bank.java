package Mines.BankOOP;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Customer> customers = new HashMap<>();
    private Map<String, Account> accounts = new HashMap<>();

    public void createAccount(String name, String pin) {
        Customer customer = new Customer(name, pin);
        Account account = new Account(customer);
        customers.put(name, customer);
        accounts.put(name, account);
    }

    public boolean loginUser(String name, String pin) throws InvalidLoginException {
        Customer customer = customers.get(name);
        if (customer == null) {
            throw new InvalidLoginException("No account found with that name.");
        }
        if (!customer.verifyPin(pin)) {
            throw new InvalidLoginException("Incorrect PIN.");
        }
        return true;
    }

    public Account getAccount(String name) {
        return accounts.get(name);
    }

    public void deleteAccount(Account account) {
        accounts.remove(account.getCustomer().getName());
        customers.remove(account.getCustomer().getName());
    }
}