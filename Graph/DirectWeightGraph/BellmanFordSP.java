package DirectWeightGraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Bellman-Ford SP algorithm based on queue
 */
public class BellmanFordSP {
    private double[] distTo; // Path length from start vertex to this point
    private DirectedEdge[] edgeTo; // The last path from start vertex to this point
    private boolean[] onQ; // Is vertex in the queue
    private Queue<Integer> queue; // Relaxing vertex
    private int cost; // Number of times relax() was called
    private Iterable<Integer> cycle; // Negetive cycle

    public BellmanFordSP(EdgeWeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new LinkedList<>();
        for (int v = 0; v < G.V(); ++v) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        queue.offer(s);
        onQ[s] = true;
        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.poll();
            onQ[v] = false;
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (!onQ[w]) {
                    queue.offer(w);
                    onQ[w] = true;
                }
            }
            if (cost++ % G.V() == 0) {
                findNegativeCycle();
            }
        }
    }

    private void findNegativeCycle() {
        int V = edgeTo.length;
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
        for (int v = 0; v < V; ++v) {
            if (edgeTo[v] != null) {
                spt.addEdge(edgeTo[v]);
            }
        }
        EdgeWeightedCycleFinder cf = new EdgeWeightedCycleFinder(spt);
        cycle = cf.cycle();
    }

    public boolean hasNegativeCycle() {
        return cycle != null;
    }

    public Iterable<Integer> negativeCycle() {
        return cycle;
    }
}
