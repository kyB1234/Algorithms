package DirectGraph;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Sort based on depth first search in direct graph
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre; // Preorder
    private Queue<Integer> post; // Postorder
    private Deque<Integer> reversePost; //ReversePost

    public DepthFirstOrder(Digraph G) {
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new LinkedList<>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); ++v) {
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(Digraph G, int v) {
        pre.offer(v);
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[v]) dfs(G, w);
        }
        post.offer(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
