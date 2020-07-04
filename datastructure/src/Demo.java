public class Demo {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int[] head = array;
        int[] array2 = {2, 3, 4, 5};
        System.out.println(head);
        System.out.println(array);
        System.out.println(array2);
        array2 = array;
        System.out.println(array2);
    }
}
