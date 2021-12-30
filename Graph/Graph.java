import java.util.ArrayList;
import java.util.List;
/**
 * Undirect graph
 */
public class Graph {
    private final int V; // Number of vertex
    private int E; // Number of edge
    private List<List<Integer>> adj; // Adjacency list

    public Graph(int V) {
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
     * @param v 
     * @param w
     */
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
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
}
