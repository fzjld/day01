package stack;

import java.util.ArrayList;
import java.util.Stack;

public class PolandNotation {
    // 逆波兰表达式的计算
    public static void main(String[] args) {
        // 定义后缀表达式(即逆波兰表达式)
        // RPN:Reverse Polish Notation
        String suffixExpression1 = "3 4 + 5 * 6 - ";
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        ArrayList<String> rpnList = getList(suffixExpression);
        System.out.println(rpnList);
        int calculate = calculate(rpnList);
        System.out.println(calculate);


        // 将中缀表达式转换为后缀表达式(逆波兰表达式)
        String infixExpression = "12+((25+3)*4)-5";
        // 如果只是单个数字可以使用toCharArray方法，然后转ArrayList
        /*char[] chars = infixExpression.toCharArray();
        System.out.println(chars[2]);
        ArrayList<Character> arrayList = new ArrayList<Character>();
        for (char s : chars) {
            arrayList.add(s);
        }
        System.out.println(arrayList);
        //如果是遇到两个数字连在一起了，比如"12+((2+3)*4)-5"，这种方法就不科学了*/

        // 将中缀表达式存在ArrayList
        ArrayList<String> infixExpressionList = getInfixExpressionList(infixExpression);
        System.out.println(infixExpressionList);  // 打印输出
        // 将中缀表达式转换为后缀表达式
        ArrayList<String> arrayList = parseSuffixExpressionList(infixExpressionList);
        System.out.println(arrayList);

    }

    // 将中缀表达式存入ArrayList中
    public static ArrayList<String> getInfixExpressionList(String s) { //  "12+((25+3)*4)-5"
        ArrayList<String> arrayList = new ArrayList<>();
        char c;
        int i = 0;
        while (i < s.length()) {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {  // 说明是一个符号，直接加入list
                arrayList.add("" + c); // 这里使用字符串拼接将字符转换为字符串
                i++;
            } else { // 遇到的不是字符
                String s1 = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    s1 = s1 + c;
                    i++;
                }
                arrayList.add(s1);
            }
        }
        return arrayList;
    }

    // 将中缀表达式转换为后缀表达式
    public static ArrayList<String> parseSuffixExpressionList(ArrayList<String> infixExpression) {
        Stack<String> s1 = new Stack<>(); // 运算符号栈
        ArrayList<String> s2 = new ArrayList<>(); // 书上说是符号栈，但是并没有出栈入栈的操作，所以用数组代替

        for (String item : infixExpression) {  //从左到右扫描表达式
            if (item.matches("\\d+")) {//如果直接扫描到数字，直接放入s2栈
                s2.add(item);
            } else if (item.equals("(")) { // 如果遇到左括号直接压入符号栈
                s1.push(item);
            } else if (item.equals(")")) { // 如果item是右括号，则依次弹出s1的栈顶元素到s2，直到遇到栈中的左括号，然后将一对括号消除掉
                while (!s1.peek().equals("(")) {  // 栈顶不等于左括号
                    s2.add(s1.pop());
                }
                s1.pop(); // 弹出左括号
            } else {  // 最后判断遇到运算符的情况，上面已经判断了item为数字或者左右括号的情况
                while (s1.size() != 0 && Operator.getPrecedence(item) <= Operator.getPrecedence(s1.peek())) {  // 判断运算符的优先级
                    //如果item的优先级小于等于栈顶元素优先级，则将栈顶元素压入s2，然后再比较item与栈顶元素的值，直到item优先级大于栈顶元素则入栈
                    s2.add(s1.pop());
                }
                s1.push(item); // 直到上面的执行完毕，即item的优先级高于栈顶元素
            }
        }
        // 将s1剩余的
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    // 将后缀表达式存入ArrayList数组中
    public static ArrayList<String> getList(String s) {
        String[] split = s.split(" ");  // 以空格作为分隔符
        ArrayList<String> list = new ArrayList<>();
        for (String element : split) {
            list.add(element);
        }
        return list;
    }

    public static int calculate(ArrayList<String> arrayList) {
        /*从左至右扫描，将3和4压入堆栈；
        遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
        将5入栈；
        接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
        将6入栈；
        最后是-运算符，计算出35-6的值，即29，由此得出最终结果*/
        Stack<String> stack = new Stack<>();
        for (String item : arrayList) {  // 从左到右遍历
            if (item.matches("\\d+")) {  // 匹配到数字
                stack.push(item); // 将数字入栈
            } else { // 如果不是数字，只可能是运算符(因为这里不含括号)
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                // 嵌套一个if elseif 语句
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num2 * num1;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                }
                stack.push("" + res);
            }

        }
        return Integer.parseInt(stack.pop());

    }


}

// 优先级的比较
class Operator {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getPrecedence(String s) {
        int result = 0;
        switch (s) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("此运算符不存在");
                break;
        }
        return result;
    }

}