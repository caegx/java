import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {
    public static void main(String[] args) {
        // accept input for principal
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;

        int principal = 0;
        float monthlyConvertedRate = 0;
        int years = 0;
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Principal (1K - 1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            
            System.out.println("Enter a value between 1000 and 1000000");
        }

        while (true) {
            System.out.print("Rate(Yearly): ");
            float monthlyRate = Float.parseFloat(scanner.nextLine());
            if (monthlyRate >= 1 && monthlyRate <= 30){
                monthlyConvertedRate = ((monthlyRate / PERCENT)/ MONTHS_IN_YEAR);
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }

        while (true){
            System.out.print("Years: ");
            int numberOfYears = scanner.nextInt();

            if (numberOfYears >= 1 && numberOfYears <= 30)
                years = numberOfYears * MONTHS_IN_YEAR;
                break;

        }


        double mortgage = principal * ((monthlyConvertedRate * (Math.pow(1 + monthlyConvertedRate, years)))/ ((Math.pow(1 + monthlyConvertedRate, years)) - 1));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);  
        System.out.println("Your monthly mortgage is: " + mortgageFormatted);
    }
    
}
