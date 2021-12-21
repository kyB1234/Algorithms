import java.util.Random;

public class QuickSort extends Sort{
    public static <T extends Comparable<T>> void sort(T[] a) {
        sort(a, 0, a.length - 1);
    }
    public static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j, hi);  
    }
    public static <T extends Comparable<T>> int partition(T[] a, int lo, int hi) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(hi - lo + 1) + lo;
        exch(a, randomIndex, lo);
        int i = lo, j = hi + 1;
        T v = a[lo];
        while (true) {
            while (compare(a[++i], v) < 0) if (i == hi) break;
            while (compare(v, a[--j]) < 0) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j; 
    }
    public static void main(String[] args) {
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        if(isSorted(a)) {
            System.out.println("Sorted");
        } else {
            System.out.println("Not sort");
        };
        show(a);
    }

}
