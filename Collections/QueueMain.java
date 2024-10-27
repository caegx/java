package Collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("c");
        queue.add("a");
        queue.add("b");
        var front = queue.peek();
        System.out.println(front);
        System.out.println(queue.remove());
        System.out.println(queue);

    }
}
