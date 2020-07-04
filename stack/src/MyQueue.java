import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);
        queue.add(4);
        queue.add(3);
        Integer remove = queue.remove();
        System.out.println(remove);
        System.out.println(queue);
        Integer poll = queue.poll();
        System.out.println(poll);
        System.out.println(queue);
    }
}
