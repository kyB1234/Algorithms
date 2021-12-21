public class Selection_Sort extends Sort{
    /**
     * Selection sort: Dividing the input list into two parts: a sorted sublist of items and a sublist of the remaining unsorted items. 
     * Initially, the sorted sublist is empty and the unsorted sublist is the entire input list.
     * Finding the smallest (or largest, depending on sorting order) element in the unsorted sublist, 
     * exchanging (swapping) it with the leftmost unsorted element (putting it in sorted order), 
     * and moving the sublist boundaries one element to the right until the list is sorted
     * @param <T>
     * @param a List to be sorted
     */
    public static <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;
        for (int i = 0; i < N; ++i) {
            int min = i;
            for (int j = i + 1; j < N; ++j) {
                if (compare(a[j], a[min]) < 0) {
                    min = j;
                }
            }
            exch(a, i, min);
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
