package Collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("sky");
        set.add("is");
        set.add("blue");
        set.add("blue");
        System.out.println(set);

        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "a", "b", "c", "c");
        Set<String> newSet = new HashSet<>(collection); // will remove 1 c
        System.out.println(newSet);

        Set<String> set1 = new HashSet<>(Arrays.asList("a", "b", "c"));
        Set<String> set2 = new HashSet<>(Arrays.asList("b", "c", "d"));

        set1.addAll(set2); // Union
        set1.retainAll(set2); // Intersection
        set1.removeAll(set2); // Difference

        System.out.println(set1); // after each operation to see
    }
}
