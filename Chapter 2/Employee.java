public class Employee {
    private int baseSalary;
    private int hourlyRate;

    //static member (field)
    public static int numberOfEmployees;

    //Constructor overloading
    public Employee(int baseSalary) {
        this(baseSalary, 0); //calling the other constructor
    }

    public Employee(int baseSalary, int hourlyRate) {
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        numberOfEmployees++;
    }
    
    public static void printNumberOfEmplyees() {
        System.out.println(numberOfEmployees);
    }
    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Salary cannot be 0 or negative.");
        }
        this.baseSalary = baseSalary;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        if (hourlyRate <=0) {
            throw new IllegalAccessError("Hourly rate cannot be 0 or negative.");
        }
        this.hourlyRate = hourlyRate;
    }

    public int calculateWage(int extraHours) {
        return baseSalary + (hourlyRate * extraHours);
    }

    public int calculateWage() {
        return calculateWage(0);
    }
}
