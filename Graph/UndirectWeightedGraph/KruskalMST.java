package UndirectWeightedGraph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalMST {
    private Queue<Edge> mst;
    private boolean[] marked;
    private double weight;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new LinkedList<>();
        marked = new boolean[G.V()];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (Edge e : G.edges()) pq.offer(e);

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;
            marked[v] = true;
            marked[w] = true;
            mst.offer(e);
            weight += e.weight();
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }
}
