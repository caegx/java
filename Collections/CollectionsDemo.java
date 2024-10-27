package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
    public static void show() {
        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "a", "b", "c");
        System.out.println(collection);
        
        Object[] objectsArray = collection.toArray();
        var stringArray = collection.toArray(new String[0]);
        System.out.println(stringArray.toString());

        Collection<String> other = new ArrayList<>();
        other.addAll(collection);
        System.out.println(other == collection);
        System.out.println(collection.equals(other));
    }
}
