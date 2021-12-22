public class Heapsort extends Sort {
    /**
     * Heap sort: First, build a max top heap using sink. Second, keep swap max element(at top of the list) and the last element of unsorted list, 
     * then using sink to restore the heap order keep doing this until no element in the heap.
     * @param <T>
     * @param a 
     */
    public static <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length - 1;
        for (int k = N / 2; k >= 1; --k) {
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }
    /**
     * Restore heap order if the element is less than its children
     */
    private static <T extends Comparable<T>> void sink(T[] a, int i, int N) {
        while (2 * i <= N) {
            int j = 2 * i;
            if (j < N && compare(a[j], a[j + 1]) < 0) ++j;
            if (compare(a[i], a[j]) >= 0) break;
            exch(a, i, j);
            i = j;
        }
    }
    public static void main(String[] args) {
        String[] a = {"", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        if(isSorted(a)) {
            System.out.println("Sorted");
        } else {
            System.out.println("Not sort");
        };
        show(a);
    }
}
