package Mines.BankOOP;

import java.util.Scanner;

public class Main {
    private static Bank bank = new Bank();
    private static BankReport bankReport;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        bankReport = new BankReport(bank);
        
        while (true) {
            bankReport.mainMenu();
            int selection = Integer.parseInt(scanner.nextLine());
            switch (selection) {
                case 1:
                    createNewAccount();
                    break;
                case 2:
                    loginCustomer();
                    break;
                case 3:
                    System.out.println("Thank you for using this Bank Management System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }

    private static void loginCustomer() {
        String name = bankReport.getInput("Enter account name.");
        String pin = bankReport.getInput("Enter account pin.");
        
        try {
            if (bank.loginUser(name, pin)) {
                Account account = bank.getAccount(name);
                bankReport.loginMenu(account);
            }
        } catch (InvalidLoginException e) {
            System.out.println(e.getMessage());
        }
    } 

    private static void createNewAccount() {
        String name = bankReport.getInput("Enter account name.");
        String pin = bankReport.getInput("Enter account pin.");
        bank.createAccount(name, pin);
        System.out.println("Account created successfully.");
        

    }
}
