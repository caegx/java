import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * HelloWorld
 */
public class Main {

    public static void main(String[] args) {
        //examples of primitive data types
        byte age = 20;
        long viewsCount = 312_345_678_90L; //L suffix because the number is too large. _ for separating them in thousands
        float price = 10.99F; //F suffix because java recognizes it as double.
        char letter = 'A';
        boolean isEligible = true;

        // examples of reference data types
        Date now = new Date();
        System.out.println(now);

        // reference types are copied by their references and primitive types are copied by their values. 

        // Strings
        String message = "Hello World" + "!!";
        
        System.out.println(message.startsWith("!"));
        System.out.println(message.endsWith("!"));
        System.out.println(message.length());
        System.out.println(message.indexOf('h'));
        System.out.println(message.replace('!', '*')); // the replace method does not modify the original string. it returns a new string
        System.out.println(message); // strings are immutable in java. 
        System.out.println(message.toLowerCase());
        System.out.println(message);
        System.out.println(message.toUpperCase());
        System.out.println(message.trim()); // removes white spaces 


        // Escape sequences
        String newMessage = "Hello \"Ben\" \\n";
        System.out.println(newMessage);

        // Arrays
        int[] numbers = new int[5]; //old way of initializing arrays
        numbers[0] = 2;
        numbers[1] = 5;
        numbers[2] = 9;
        
        System.out.println(Arrays.toString(numbers));

        int[] newNumbers = {9, 4, 8, 5, 7, 6 };
        System.out.println(newNumbers.length);

        Arrays.sort(newNumbers);
        System.out.println(Arrays.toString(newNumbers));


        //multi-dimensional arrays

        int[][] matrix = new int[2][3];
        matrix[0][0] = 1;
        System.out.println(Arrays.deepToString(matrix));
        
        int[][] newMatrix = {{1, 3, 5}, {4, 9, 8}};
        System.out.println(Arrays.deepToString(newMatrix));

        //constants 
        final float PI = 3.142F;

        //arithmetic expressions
        double result = (double) 10 / (double) 3;
        System.out.println(result);
        

        //casting 
        // Implicit casting
        short x = 1;
        int y = x + 2;
        System.out.println(y);

        double floatX = 1.1;
        double floatY = floatX + 2;
        System.out.println(floatY);

        //Explicit casting
        double newFloat = 1.1;
        int newY = (int)newFloat + 2;
        System.out.println(newY);

        String stringX = "1";
        int intY = Integer.parseInt(stringX) + 2;
        System.out.println(intY);

        String doubleX = "1.1";
        double doubleY = Double.parseDouble(doubleX) + 2;
        System.out.println(doubleY);

        // the Math class

        int answer = Math.round(1.1F);
        System.out.println(answer); 

        int random = (int) (Math.random() * 100); // because the random method gives a random number between 0 and 1    
        System.out.println(random);


        //Formatting Numbers 

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String currencyResult = currency.format(1234567.891);
        System.out.println(currencyResult);

        // this is also correct
        String percent = NumberFormat.getPercentInstance().format(0.34);
        System.out.println(percent);


        //Reading inputs.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name?");
        String userName = scanner.nextLine(); // reading the data. can be nextFloat or nextFloat depending on the data type 
        // for strings we write String name = scanner.nextLine()
        System.out.println("You are " + userName.trim() + ".");



    }
}