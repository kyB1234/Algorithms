package DirectWeightGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Weighted directed graph
 */
public class EdgeWeightedDigraph {
    private final int V; // Number of vertices
    private int E; // Number of edges
    private List<List<DirectedEdge>> adj; // Adjacency list

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new ArrayList<>();
        for (int i = 0; i < V; ++i) {
            adj.add(new ArrayList<>());
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj.get(e.from()).add(e);
        ++E;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj.get(v);
    }

    public Iterable<DirectedEdge> edges() {
        List<DirectedEdge> edges = new ArrayList<>();
        for (int v = 0; v < V; ++v) {
            for (DirectedEdge e : adj.get(v)) {
                edges.add(e);
            }
        }
        return edges;
    }
}
