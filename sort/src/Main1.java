public class Main1 {
    public static void main(String[] args) {
        // Integer等包装类实现了Comparable接口
        // 等于说一个包装类对象就是一个Comparable接口的实现类，可以使用compareTo方法
        Integer a = 5;
        System.out.println(a);
        // 当数字小于比较对象时，返回-1
        System.out.println(a.compareTo(6));
        // 当数字大于比较对象时，返回1
        System.out.println(a.compareTo(4));
        // 拆箱
        int a1 = a;
        // 装箱
        int b = 2;
        Integer b1 = b;
        System.out.println(b1);
    }
}
