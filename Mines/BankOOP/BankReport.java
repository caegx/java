package Mines.BankOOP;

import java.util.Scanner;

public class BankReport {
    private Bank bank;
    private Scanner scanner;

    public BankReport(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void mainMenu() {
        System.out.println("Hi. Welcome to Bank Management System.");
        System.out.println("1. Create Account");
        System.out.println("2. Login to an existing account");
        System.out.println("3. Exit.");
    }

    public void loginMenu(Account account) {
        while (true) {
            System.out.println("1. View Account Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Account Settings");
            System.out.println("6. Logout");

            int selection = Integer.parseInt(scanner.nextLine());
            switch (selection) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    handleDeposit(account);
                    break;
                case 3:
                    handleWithdrawal(account);
                    break;
                case 4:
                    handleTransfer(account);
                    break;
                case 5:
                    handleAccountSettings(account);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }

    private void handleDeposit(Account account) {
        System.out.println("How much would you like to deposit?");
        var amount = Double.parseDouble(scanner.nextLine());
        try {
            account.deposit(amount);
        } catch (InvalidDepositAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleWithdrawal(Account account) {
        System.out.println("How much would you like to withdraw?");
        var amount = Double.parseDouble(scanner.nextLine());
        try {
            account.withdraw(amount);
        } catch (InvalidWithdrawalAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleTransfer(Account account) {
        System.out.println("Enter the name of the account you want to transfer to:");
        var name = scanner.nextLine();
        System.out.println("How much would you like to transfer?");
        var amount = Double.parseDouble(scanner.nextLine());
        try {
            account.transfer(amount, name);
        } catch (InvalidTransferAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleAccountSettings(Account account) {
        System.out.println("1. Change PIN");
        System.out.println("2. Delete Account");
        System.out.println("3. Back");
        var selection = Integer.parseInt(scanner.nextLine());
        switch (selection) {
            case 1:
                handleChangePIN(account);
                break;
            case 2:
                handleDeleteAccount(account);
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid selection.");
        }
    }

    private void handleChangePIN(Account account) {
        System.out.println("Enter your new PIN:");
        var pin = scanner.nextLine();
        account.changePIN(pin);
    }

    private void handleDeleteAccount(Account account) {
        System.out.println("Are you sure you want to delete your account? (y/n)");
        var confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("y")) {
            bank.deleteAccount(account);
        }
    }

    public String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

}
