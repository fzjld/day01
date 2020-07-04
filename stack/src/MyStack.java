import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("hahah");
        stack.push("xixixi");
        String pop1 = stack.pop();
        String pop2 = stack.pop();
        stack.push("xxxxx");
        System.out.println(pop1);
        System.out.println(pop2);
//        stack.peek();
        System.out.println(stack.isEmpty());

    }
}
