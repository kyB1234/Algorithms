import java.util.Random;

public class QuickSort3Way extends Sort{
    /**
     * QuickSort3Way: Compare to the quick sort, it has better performance when list has many duplicate elements
     * @param <T>
     * @param a
     */
    public static <T extends Comparable<T>> void sort(T[] a) {
        sort(a, 0, a.length - 1);
    }
    public static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return;
        Random rand = new Random();
        int randomIndex = rand.nextInt(hi - lo + 1) + lo;
        exch(a, randomIndex, lo);
        int lt = lo, i = lo + 1, gt = hi;
        T v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else ++i;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);  
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
