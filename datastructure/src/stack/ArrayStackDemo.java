package stack;


// 使用数组模拟栈的操作

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(4);
        arrayStack.push(3);
        arrayStack.push(5);
        arrayStack.push(7);
//        System.out.println(Arrays.toString(arrayStack.getArray()));
        arrayStack.showStack();
        System.out.printf("栈顶的值为%d:", arrayStack.peek());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }
}


class ArrayStack {
    private int maxSize;
    private int top = -1;
    private int[] array;

    public int[] getArray() {
        return array;
    }

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    // 判断是否满(进栈判断用)
    public boolean isFull() {
        return maxSize - 1 == top;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    // 模拟进栈
    public void push(int num) {
        if (isFull()) {
            System.out.println("栈已满，不可继续添加元素");
            return;
        }
        top++;
        array[top] = num;
    }

    // 模拟出栈
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈为空，无元素出栈");
            throw new RuntimeException();
        }
        int i = array[top];
        top--;
        return i;
    }

    // 遍历栈元素
    public void showStack() {
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, array[i]);
        }
    }

    public int peek() {
        return array[top];
    }


}