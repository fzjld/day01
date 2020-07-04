package stack;


//使用栈计算表达式
public class CalculatorDemo {
    public static void main(String[] args) {
        // 一个数栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(5);
        ArrayStack2 stringStack = new ArrayStack2(5);
        String a = "chenxin";
        System.out.println(a.substring(1, 3).charAt(1));
        stringStack.push('a');
    }
}


//用数组模拟栈，需要额外增加三个功能
class ArrayStack2 {
    private int maxSize;
    private int top = -1;
    private int[] array;

    public int[] getArray() {
        return array;
    }

    public ArrayStack2(int maxSize) {
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

    // 查看栈顶元素
    public int peek() {
        return array[top];
    }

    //设置优先级的元素
//    public

    //
}