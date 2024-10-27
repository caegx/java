public class TaxCalculator2019 implements CanCalculateTax {
    private double taxableIncome;

    public TaxCalculator2019(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }
    
    @Override
    public double calculateTax() {
        return 0.3 * taxableIncome;
    }

    
}