package Exceptions;
import java.io.IOException;

public class ExceptionsDemo {

    public static void show() throws IOException {
        //try with resources
        /* try(
            var reader = new FileReader("file.txt");
            var writer = new FileWriter("...");
        ) {
            var value = reader.read();
            new SimpleDateFormat().parse("");
        }catch (IOException | ParseException e) {
            System.out.println("Could not read data.");
        
        } */

        /* var account = new Account();
        try {
            account.deposit(-100);
        } catch (IOException e) {
            System.out.println("Logging");
            throw e;
        } */

        var account = new Account();
        try {
            account.withdraw(10);
        } catch (AccountException e) {
            var cause = e.getCause();
            System.out.println(cause.getMessage());
        } 

        try {
            account.deposit(0);
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }

        /* try {
            account.withdraw(10);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } */
    }
}

