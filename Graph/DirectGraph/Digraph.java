package DirectGraph;
import java.util.ArrayList;
import java.util.List;

/**
 * Direction graph
 */
public class Digraph {
    private final int V; // Number of vertex
    private int E; // Number of edge
    private List<List<Integer>> adj; // Adjacency list

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new ArrayList<>();
        for (int v = 0; v < V; ++v) {
            adj.add(new ArrayList<>());
        }
    }
    /**
     * Get the number of vertex
     * @return
     */
    public int V() {return V;}
    /**
     * Get the number of Edge
     * @return
     */
    public int E() {return E;}
    /**
     * Create a edge between two vertex
     * Only difference compare to undirection graph
     * @param v 
     * @param w
     */
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        ++E;
    }
    /**
     * Get all adjecent vertex
     * @param v
     * @return
     */
    public List<Integer> adj(int v) {
        return adj.get(v);
    }

    /**
     * Reverse direction of graph
     * @return
     */
    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; ++v) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }
}
