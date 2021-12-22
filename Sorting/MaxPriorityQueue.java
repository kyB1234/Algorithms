/**
 * Max priority queue based on binary heap
 */
public class MaxPriorityQueue<Key extends Comparable<Key>> {
    private Key[] pq; // binary heap
    private int N = 0; //number of element, not include pq[0]

    @SuppressWarnings("unchecked")
    public MaxPriorityQueue(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }
    /**
     * Check  whether the queue is empty
     * @return 
     */
    public boolean isEmpty() {
        return N == 0;
    }
    /**
     * Get the number of element in the queue
     * @return
     */
    public int size() {
        return N;
    }
    /**
     * Insert an element into the queue
     * @param v
     */
    public void insert(Key v) {
        pq[++N] = v;
        swim(N); // Restore heap order
    }
    /**
     * Delete the max element of the queue
     * @return the max element
     */
    public Key delMax() {
        Key max = pq[1]; // The max element is the root
        exch(1, N--); // Change it with the last element
        pq[N + 1] = null;
        sink(1); // Restore heap order
        return max;
    }
    /**
     * Compare whether the first element is less than the second
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
    /**
     * Exchange the position of two elements in the queue
     * @param i
     * @param j
     */
    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t; 
    }
    /**
     * Restore heap order if the element is greate than its father
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }
    /**
     * Restore heap order if the element is less than its children
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) ++j;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

}
