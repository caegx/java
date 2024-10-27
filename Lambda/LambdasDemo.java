package Lambda;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

//A functional interface is an interface with a single abstract class
// There are 4 types of functional interfaces:
// 1. Consumer: Represents an operation that accepts a single input argument and returns no result.
// 2. Supplier: Takes no arguments and returns a result.
// 3. Predicate: Represents an operation that takes an object and checks if it matches a certain criteria.
// 4. Function: Represents a function that can map a value to another value.

public class LambdasDemo {
    public LambdasDemo(String message) {}


    public static void main(String[] args) {

        show();
        show2();
        supplierShow();
        functionShow();
        composeFunction();
        predicateShow();
        combinePredicates();
        binaryOperator();
        unaryOperator();

        //Lambda expression
        greet(message -> System.out.println(message));

        //Method reference
        greet(LambdasDemo::print);

        //Instance method reference
        /* greet(new LambdasDemo()::instancePrint);

        // or 
        var demo = new LambdasDemo();
        greet(demo::instancePrint);
 */
        //Constructor reference
        greet(LambdasDemo::new);

        //Lambda expression
        //Printer printer = message -> System.out.println(message);

        //Anonymous class
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });
    }

    public  void instancePrint(String message) {}

    public static void print(String message) {}

    public static void greet(Printer printer) {
        printer.print("Hello World");
    }

    public static void show() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        list.forEach(System.out::println);
    }

    //Chaining Consumers
    public static void show2() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        Consumer    <Integer> consumer = System.out::println;
        list.forEach(consumer.andThen(i -> System.out.println(i * 2)));

        List<String> list2 = List.of("a", "b", "c", "d", "e");
        Consumer<String> print = System.out::println;
        //Consumer<String> printUpperCase = String::toUpperCase;
        // or 
        Consumer<String> printUpperCase2 = item -> System.out.println(item.toUpperCase()); //same as printUpperCase
        list2.forEach(print.andThen(printUpperCase2));
    }

    //Supplier
    public static void supplierShow() {
        Supplier<Double> getRandom = () -> Math.random();
        System.out.println(getRandom.get()); 
    }

    //Function
    public static void functionShow() {
        Function<String, Integer> map = String::length;
        // or 
        Function<String, Integer> map2 = item -> item.length();
        System.out.println(map.apply("Hello"));
        System.out.println(map2.apply("Hello"));
    }

    //Composing Functions
    public static void composeFunction() {
        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBraces = str -> "{" + str + "}";
        System.out.println(replaceColon.andThen(addBraces).apply("key:value"));
        System.out.println(addBraces.compose(replaceColon).apply("key:value"));
        System.out.println(replaceColon.compose(addBraces).apply("key:value"));
    }

    //Predicate
    public static void predicateShow() {
        Predicate<String> isLongerThan5 = str -> str.length() > 5;
        System.out.println(isLongerThan5.test("Hello"));
    }

    //Combining Predicates
    public static void combinePredicates() {
        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");
        Predicate<String> hasLeftAndRightBrace = hasLeftBrace.and(hasRightBrace);
        System.out.println(hasLeftAndRightBrace.test("{Hello}"));
        System.out.println(hasLeftBrace.or(hasRightBrace).test("{Hello}"));
        System.out.println(hasLeftBrace.negate().test("{Hello}"));

        Predicate<Integer> isEven = num -> num % 2 == 0;
        if (isEven.test(2)) {
            System.out.println("2 is even");
        }else {
            System.out.println("2 is odd");
        }



        //works like the logical &&, ||, !
    }

    //Binary Operator
    public static void binaryOperator() {
        BinaryOperator<Integer> add = (a, b) -> a + b;
        Function<Integer, Integer> square = a -> a * a;
        System.out.println(add.andThen(square).apply(2, 3));
    }

    //Unary Operator
    public static void unaryOperator() {
        UnaryOperator<Integer> square = a -> a * a;
        UnaryOperator<Integer> increment = a -> a + 1;
        var result = increment.andThen(square).apply(2);
        System.out.println(result);
    }

}
