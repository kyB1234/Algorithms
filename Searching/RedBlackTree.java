/**
 * Red Black tree: The idea of red bleak tree is using basic binary search tree and other some information to represent 2-3 tree
 * Two red chain represent the 3- Node, black chain represent the 2- Node
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**
     * Element of the tree
     */
    private class Node {
        private Key key; // Key
        private Value val; // Value
        private Node left, right; // Point to the children
        private int N; // The total number of nodes in the subtree rooted on this node
        boolean color; // The color of chain to which the father points
        public Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
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
     * Get the color of the chain between this node and its father
     * @param x The Node
     * @return true: RED, false: BLACK
     */
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    /**
     * Left rotate Node
     * @param h
     * @return The root of new subtree
     */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * Right rotate Node
     * @param h
     * @return The root of new subtree
     */
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * Change two red children to black, and its color to red inorder ot maintain the whole Black height
     * @param h
     */
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    /**
     * Put a node into tree
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    /**
     * Put a node into tree, if key exist, renew it value, 
     * if not, insert a new node into the subtree
     * @param x Root of a subtree
     * @param key Key
     * @param val Value
     * @return the root of the tree
     */
    private Node put(Node h, Key key, Value val) {
        if (h == null) return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;
        if (isRed(h.right) && !isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }
}
