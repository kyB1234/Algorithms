public abstract class Sort {
    /**
     * Sort algorith
     * @param <T>
     * @param a List to be sorted
     */
    public static <T extends Comparable<T>> void sort(T[] a) {}
    /**
     * Compare two elements
     * @param <T>
     * @param v First element
     * @param w Second element
     * @return 0 (v = w); > 0 (v > w); < 0 (v < m)
     */
    public static <T extends Comparable<T>> int compare(T v, T w) {
        return v.compareTo(w);
    }
    /**
     * Swap the positions of two elements in the list
     * @param <T>
     * @param a Array
     * @param i Position of first element
     * @param j Position of second element
     */
    protected static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    /**
     * Print the list
     * @param <T>
     * @param a
     */
    protected static <T extends Comparable<T>> void show(T[] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    /**
     * Check whether the list is sorted
     * @param <T>
     * @param a
     * @return Ture: sorted; False: unsorted
     */
    protected static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; ++i) {
            if (compare(a[i], a[i - 1]) < 0) return false;
        }
        return true;
    }
}