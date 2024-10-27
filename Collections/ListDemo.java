package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void show () {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c");
        System.out.println(list.get(0));
        list.add(0, "!");
        System.out.println(list.get(0));
        System.out.println(list);
    }
}
