import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    private MortgageCalculator calculator;
    private NumberFormat currency;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance(Locale.US);
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currency.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("---------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public void printBalance() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (double balance : calculator.getRemainingBalances())
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(balance));
        
    }
    
}
