package DirectWeightGraph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Shortest Path at Weighted Undirected Acyclic Graph
 */
public class AcyclicSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;


    public AcyclicSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for (int v = 0; v < G.V(); ++v) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        Iterable<Integer> topOrder = Topological(G);
        for (int v : topOrder) {
            relax(G, v);
        }
        
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }

    private Iterable<Integer> Topological(EdgeWeightedDigraph G) {
        Deque<Integer> reversePost = new LinkedList<>();
        boolean[] marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); ++v) {
            if (!marked[v]) dfs(G, v, reversePost, marked);
        }
        return reversePost;
    }

    private void dfs(EdgeWeightedDigraph G, int v, Deque<Integer> reversePost, boolean[] marked) {
        marked[v] = true;
        for (DirectedEdge w : G.adj(v)) {
            if (!marked[v]){
                dfs(G, w.to(), reversePost, marked);
            }
        }
        reversePost.push(v);
    }
}
