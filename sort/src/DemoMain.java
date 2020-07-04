import java.util.Arrays;

public class DemoMain {
    public static void main(String[] args) {
        Comparable[] a = {4, 3, 7, 5, 3, 23, 2};
        exch(a, 1, 2);
//        System.out.println();
        System.out.println(a[2]);
        System.out.println(Arrays.toString(a));
        //        sort(a);
//        System.out.println(Arrays.toString(a));
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }
}
