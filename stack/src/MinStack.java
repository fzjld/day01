import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.pop();
    }

    public int getMin() {
        for (int i = 0; i < stack.size(); i++) {

        }
    }
}

