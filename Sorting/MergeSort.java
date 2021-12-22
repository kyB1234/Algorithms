public class MergeSort extends Sort {
    /**
     * Merge two sorted sublist into one sorted list
     * @param <T>
     * @param a List
     * @param lo First sublist begin position
     * @param mid First sublist end position
     * @param hi Second sublist end position
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void merge(T[] a, int lo, int mid, int hi) {
        int i = mid, j = hi - mid - 1;
        T[] rightList = (T[]) new Comparable[hi - mid];
        for (int k = mid + 1; k <= hi; ++k) {
            rightList[k - mid - 1] = a[k];
        }
        int index = hi;
        for (; index >= 0; --index) {
            if (i < lo || j < 0) break;
            if (compare(a[i], rightList[j]) < 0) {
                a[index] = rightList[j--];
            } else {
                a[index] = a[i--];
            }
        }
        for (; j >= 0; --j) a[index--] = rightList[j--];
    }
    /**
     * Merge Sort 
     * @param <T>
     * @param a List
     */
    public static <T extends Comparable<T>> void sort(T[] a) {
        sort(a, 0, a.length - 1);
    }
    /**
     * Merge Sort: Divide the unsorted list into n sublists, each containing one element (a list of one element is considered sorted).
     * Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining.
     * @param <T>
     * @param a List
     * @param lo Start position of the unsorted list
     * @param hi End position of the unsorted list
     */
    public static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
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
