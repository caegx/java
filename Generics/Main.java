package Generics;

public class Main {
    public static void main(String[] args) {
        var user1 = new User(10);
        var user2 = new User(20);

        if(user1.compareTo(user2) < 0)
            System.out.println("user1 < user2");
        else if(user1.compareTo(user2) == 0)
            System.out.println("user1 = user2");
        else
            System.out.println("user1 > user2");

        var max = Utils.max(1, 2);
        System.out.println(max);

        var maximum = Utils.max(new User(10), new User(20));
        System.out.println(maximum.toString());

        Utils.print(1, 10);

        var instructors = new GenericList<Instructor>();
        var users = new GenericList<User>();
        Utils.printUsers(instructors);

        var list = new GenericList<String>();
        list.add("a");
        list.add("b");
        for (var item : list) {
            System.out.println(item);
        }
    }
}
