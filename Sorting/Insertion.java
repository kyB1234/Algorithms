public class Insertion extends Sort {
    /**
     * Insertion sort: Checking each element of the list from left to right. 
     * At each element, removes it from the input data, finds the location it belongs and inserts it there. 
     * It repeats until no input elements remain.
     * @param <T>
     * @param a List to be sorted
     */
    public static <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;
        for (int i = 1; i < N; ++i) {
            for (int j = i; j > 0 && compare(a[j], a[j - 1]) < 0; --j) {
                exch(a, j, j - 1);
            }
        }
    }
    /**
     * Insertion sort improved: Moving the big element rather than swap it in each step
     * @param <T>
     * @param a
     */
    public static <T extends Comparable<T>> void sort_Improved(T[] a) {
        int N = a.length;
        for (int i = 1; i < N; ++i) {
            T t = a[i];
            int index = i;
            for (int j = i - 1; j >= 0 && compare(t, a[j]) < 0; --j) {
                a[j + 1] = a[j];
                index = j;
            }
            a[index] = t;
        }
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
