package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var list = new GenericList<String>();
        list.add("a");
        list.add("b");
        var iterator = list.iterator();
        while (iterator.hasNext()) { 
            var current = iterator.next();
            System.out.println(current);
        }

        CollectionsDemo.show();
        ListDemo.show();

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("a", "e3"));
        customers.add(new Customer("b", "e2"));
        customers.add(new Customer("c", "e1"));

        Collections.sort(customers);
        Collections.sort(customers, new EmailComparator());
        System.out.println(customers.toString());

    }
}
