import java.util.LinkedList;
import java.util.Queue;

// 用队列实现栈功能
public class QueuePrac {
    private Queue<Integer> queue = new LinkedList<>();

    public QueuePrac() {

    }

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            // 出队又入队
            queue.add(queue.poll());
        }
//        int s = queue.size();
//        while (s-- > 1) {
//            queue.add(queue.poll());
//        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.remove();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}
