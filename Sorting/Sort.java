public abstract class Sort {
    public static <T extends Comparable<T>> void sort(T[] a) {}
    private static <T extends Comparable<T>> int compare(T v, T w) {
        return v.compareTo(w);
    }
    private static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static <T extends Comparable<T>> void show(T[] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; ++i) {
            if (compare(a[i], a[i - 1]) < 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}