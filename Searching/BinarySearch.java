public class BinarySearch {
    public static <T extends Comparable<T>> int search(T[] a, T key) {
        return search(a, key, 0, a.length - 1);
    }

    public static <T extends Comparable<T>> int search(T[] a, T key, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(a[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
}
