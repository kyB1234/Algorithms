public class ShellSort extends Sort {
    /**
     * ShellSort: An optimization of insertion sort that allows the exchange of items that are far apart.
     * Arrange the list of elements, taking every hth element produces a sorted list.
     * Beginning with large values of h allows elements to move long distances in the original list, 
     * reducing large amounts of disorder quickly, and leaving less work for smaller h-sort steps to do.
     * This shellsort using Marcin Ciura's gap sequence.
     * @param <T>
     * @param a List to be sorted
     */
    public static <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = h* 3 + 1;
        while (h >= 1) {
            for (int i = h; i < N; ++i) {
                for (int j = i; j >= h && compare(a[j], a[j - h]) < 0; j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
    public static void main(String[] args) {
        String[] a = {"S", "H", "E", "L", "L", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        if(isSorted(a)) {
            System.out.println("Sorted");
        } else {
            System.out.println("Not sort");
        };
        show(a);
    }
}
