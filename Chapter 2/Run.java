public class Run {
    public static void main(String[] args) {
        var employee = new Employee(50_000, 20);

        System.out.println(Employee.numberOfEmployees);
        Employee.printNumberOfEmplyees();

    }
}
