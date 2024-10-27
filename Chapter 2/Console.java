import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double getInput(String prompt) {
        return scanner.nextDouble();
    }
    
    public static double getInput(String prompt, int min, int max){
        double value;
        while (true){
            System.out.print(prompt);
            if (scanner.hasNextDouble()){
                value = scanner.nextDouble();
                if (value >= min && value <= max)
                    break;
                System.out.println("Enter a value between " + min + " and " + max);
            }else{
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
        return value;
    }
    
}
