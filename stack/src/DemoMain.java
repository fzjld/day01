public class DemoMain {
    public static void main(String[] args) {
        // 用队列实现栈的功能
        QueuePrac queuePrac = new QueuePrac();
        queuePrac.push(1);
        queuePrac.push(2);
        queuePrac.push(3);
        int pop = queuePrac.pop();
        System.out.println(pop);
        System.out.println(queuePrac.empty());
        System.out.println(queuePrac.top());
    }
}
