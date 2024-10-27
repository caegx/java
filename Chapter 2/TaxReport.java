public class TaxReport {
    private CanCalculateTax calculator;

    
    public TaxReport(CanCalculateTax calculator) {
        this.calculator = calculator;  //constructor injection
    }
    
    public void show(CanCalculateTax calculator){
        var tax = calculator.calculateTax(); //method injection
        System.out.println(tax);
    }
    
    public void setCalculator(CanCalculateTax calculator) {
        this.calculator = calculator; //setter injection
    }
}