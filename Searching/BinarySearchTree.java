/**
 * Binary Search Tree
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    /**
     * Element of the tree
     */
    private class Node {
        private Key key; // Key
        private Value val; // Value
        private Node left, right; // Point to the children
        private int N; // The total number of nodes in the subtree rooted on this node
        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
    private Node root; // Root node

    public int size() {
        return size(root);
    }
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    /**
     * Get the value by key
     * @param key
     * @return
     */
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * Find the value of the key in the subtree rooted by this node
     * @param x root node
     * @param key Key
     * @return Value if find, null if not find
     */
    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    /**
     * Put a node into tree
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    /**
     * Put a node into tree, if key exist, renew it value, 
     * if not, insert a new node into the subtree
     * @param x Root of a subtree
     * @param key Key
     * @param val Value
     * @return the root of the tree
     */
    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp > 0) x.left = put(x.left, key, val);
        else if (cmp < 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * Get the minimum key of this tree
     * @return The minimum key
     */
    public Key min() {
        return min(root).key;
    }

    /**
     * Get the node with minimum key
     * @param x Root of the subtree
     * @return The node with minimun key
     */
    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    /**
     * Get the maximum key of this tree
     * @return The maximum key
     */
    public Key max() {
        return max(root).key;
    }

    /**
     * Get the node with Maximum key
     * @param x Root of the subtree
     * @return The node with maximum key
     */
    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    /**
     * Get the floor of the key
     * @param key Key
     * @return The floor of the key
     */
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    /**
     * Get the node of floor
     * @param x Root of the subtree
     * @param key Key
     * @return The node of floor
     */
    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    /**
     * Get the ceiling of the key
     * @param key Key
     * @return The ceil of the key
     */
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        return x.key;
    }

    /**
     * Get the node of ceiling
     * @param x Root of the subtree
     * @param key Key
     * @return The node of ceiling
     */
    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return floor(x.right, key);
        Node t = floor(x.left, key);
        if (t != null) return t;
        else return x;
    }

    /**
     * Get the key which has k keys smaller than it
     * @param k The number of keys
     * @return the key which has k keys smaller than it
     */
    public Key select(int k) {
        return select(root, k).key;
    }

    /**
     * Get the node which has k keys smaller than its key
     * @param x Root of the subtree
     * @param k The number of keys
     * @return The node which has k keys smaller than its key
     */
    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t  - 1);
        else return x;
    }

    /**
     * Get the rank of the key
     * @param key Key
     * @return The rank of the key
     */
    public int rank(Key key) {
        return rank(root, key);
    }

    /**
     * Get the rank of the key
     * @param x Root of the subtree
     * @param key Key
     * @return The rank of the key
     */
    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left, key);
        else if (cmp > 0) return 1 + size(x.left) + rank(x.right, key);
        else return size(x.left);
    }

    /**
     * Delete node which has minimum key
     */
    public void deleteMin() {
        root = deleteMin(root);
    }

    /**
     * Delete node which has minimum key
     * @param x Root of the subtree
     * @return Root
     */
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * Delete node
     * @param key 
     */
    public void delete(Key key) {
        root = delete(root, key);
    }

    /**
     * Delete node
     * @param x Root of the subtree
     * @param key Key
     * @return
     */
    public Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
}