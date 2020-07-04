import java.util.Arrays;
import java.util.Scanner;

public class DemoArrayQueue {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int next = scanner.nextInt();
                    queue.addQueue(next);
                    break;
                case 'g':
                    queue.getQueue();
                    break;
                case 'h':
                    queue.headQueue();
                    break;
                case 'e':
                    loop = false;
                    break;
            }
        }
        System.out.println("程序结束");
    }
}

// 使用数组模拟队列
class ArrayQueue {
    private int front = -1;
    private int rear = -1;
    private int maxSize;
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    public void headQueue() { // 显示头部的元素
        System.out.println(arr[front]);
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无法显示元素");
            return;
        }
        System.out.println(Arrays.toString(arr));
    }

    public void addQueue(int n) {
        if (isFull()) {
//            throw new RuntimeException("队列已满不能添加数据");
            System.out.println("队列已满，不能添加数据了");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空不能取元素");
        }
        front++;
        return arr[front];
    }
}
