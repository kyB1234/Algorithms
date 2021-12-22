import java.util.Random;

public class QuickSort extends Sort{
    /**
     * QuickSort: Selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, 
     * according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively.
     * @param <T>
     * @param a
     */
    public static <T extends Comparable<T>> void sort(T[] a) {
        sort(a, 0, a.length - 1);
    }
    public static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);  
    }
    /**
     * Partition: Choosing first element as pivot and scanning the remaining element, 
     * put pivot into right position which its left element is not large than it and 
     * right element is not less than it  
     * @param <T>
     * @param a
     * @param lo
     * @param hi
     * @return the position of pivot
     */
    public static <T extends Comparable<T>> int partition(T[] a, int lo, int hi) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(hi - lo + 1) + lo;
        exch(a, randomIndex, lo);
        T v = a[lo];
        // From two side
        int i = lo, j = hi + 1;
        while (true) {
            while (compare(a[++i], v) < 0) if (i == hi) break;
            while (compare(v, a[--j]) < 0) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;


        // From one side
        // int i = hi + 1, j = hi + 1;
        // while (--j >= lo) {
        //     if (compare(a[j], v) >= 0) {
        //         exch(a, --i, j);
        //     }
        // }
        // return i;
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
