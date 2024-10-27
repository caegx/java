package Generics;

public class Utils {
    public static <T extends Comparable<T>> T max(T first, T second) {
        return (first.compareTo(second) < 0) ? second : first;
    }

    public static <K, V> void print(K key, V value) {
        System.out.println(key + "=" + value);
    }

    public static void printUser(User user){
        System.out.println(user);
    }

    public static void printUsers(GenericList<? extends User> users) {
        //if you wanna read from this list, use the extends keyword GenericList<? extends User>
        //if you wanna add to it, use the super keyword GenericList<? super User>
        System.out.println(users);
    }
    
}
