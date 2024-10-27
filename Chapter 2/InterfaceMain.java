public class InterfaceMain {

    public static void main(String[] args) {
        var calculator = new TaxCalculator2019(100_000);
        var report = new TaxReport(calculator);
        report.show(calculator);
    }
}