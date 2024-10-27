package Collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        var c1 = new Customer("a", "e1");
        var c2 = new Customer("b", "e2");

        Map<String, Customer> map = new HashMap<>();
        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);

        var customer = map.get("e1");
        System.out.println(customer);
        System.out.println(map);

        // iterating over maps

        for (var key : map.keySet())
            System.out.println(key);

            for (var entry : map.entrySet()) {
                System.out.println(entry);
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
            }

        for (var getCustomer : map.values())
            System.out.println(getCustomer);
    }
}
