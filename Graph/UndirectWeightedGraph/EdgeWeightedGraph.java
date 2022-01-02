package UndirectWeightedGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Weighted undirected grapth
 */
public class EdgeWeightedGraph {
    private final int V; // Number of vertex
    private int E; //Number of edges
    private List<List<Edge>> adj; // Adjacency list

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new ArrayList<>();
        for (int v = 0; v < V; ++v) {
            adj.add(new ArrayList<>());
        }
    }

    public int V() { return V; }

    public int E() { return E; }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj.get(v).add(e);
        adj.get(w).add(e);
        ++E;
    }

    public Iterable<Edge> adj(int v) { return adj.get(v); }

    public Iterable<Edge> edges() {
        List<Edge> listEdge = new ArrayList<>();
        for (int v = 0; v < V; ++v) {
            for (Edge e : adj.get(v)) {
                if (e.other(v) > v) listEdge.add(e);
            }
        }
        return listEdge;
    }
}
