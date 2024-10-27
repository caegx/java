public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private float annualRate;
    private int years;
    


    public MortgageCalculator(int principal, float annualRate, int years) {
        this.principal = principal;
        this.annualRate = annualRate;
        this.years = years;
    }

    

    public double calculateBalance(int numberOfPaymentsMade){
        float numberOfPayments = getNumberOfPayments();
        float monthlyRate = getMonthlyInterest();
        double balance = principal * (Math.pow(1 + monthlyRate , numberOfPayments) - Math.pow(1 + monthlyRate, numberOfPaymentsMade))/(Math.pow(1 + monthlyRate, numberOfPayments)-1);
        return balance;
    }



    
    public double calculateMortgage(){
        float numberOfPayments = getNumberOfPayments();
        float monthlyRate = getMonthlyInterest();
        
        double mortgage = principal * ((monthlyRate * (Math.pow(1 + monthlyRate, numberOfPayments)))/ ((Math.pow(1 + monthlyRate, numberOfPayments)) - 1));
        return mortgage;
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateBalance(month);

        return balances;
    }

    
    
    public int getYears() {
        return years;
    }
    
    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }
    
    private float getMonthlyInterest() {
        return (annualRate / PERCENT)/ MONTHS_IN_YEAR;
    }

}
