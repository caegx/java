import java.util.Scanner;

public class New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int principal = (int) Console.getInput("Principal (1K - 1M): ", 1000, 1_000_000);
        float monthlyRate = (float) Console.getInput("Rate(Yearly): ", 1, 30);
        int years = (int)Console.getInput("Years: ", 1, 30);

        var calculator = new MortgageCalculator(principal, monthlyRate, years);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printBalance();


        scanner.close();
    }

    
}
