package Mines.BankOOP;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static <T>T[] removeDuplicates(T[] inputArray) {
        Set<T> set = new HashSet<>(Arrays.asList(inputArray));
        return set.toArray((T[]) Array.newInstance(inputArray.getClass().getComponentType(), set.size()));
    }

    public static void main(String[] args) {
        Integer[] array = { 12, 3, 9, 9, 12, 13, 8, 9, 1, 2, 3, 3, 3, 14, 4, 5, 6, 7, 8, 9, 10};
        Integer[] result = removeDuplicates(array);
        System.out.println(Arrays.toString(result));
    }
}
