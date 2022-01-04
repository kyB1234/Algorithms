package DirectWeightGraph;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Find circle in direct graph
 */
public class EdgeWeightedCycleFinder {
    private boolean[] marked;
    private int[] edgeTo;
    private Deque<Integer> cycle; // All vertex in direct circle (if exist)
    private boolean[] onStack;

    public EdgeWeightedCycleFinder(EdgeWeightedDigraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); ++v) {
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(EdgeWeightedDigraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (this.hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new LinkedList<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {return cycle != null;}

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
