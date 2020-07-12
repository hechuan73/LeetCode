package items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hechuan
 */
public class PathWithMaximumProbability_1514 {

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Graph graph = new Graph(n);
        int v1, v2;
        double weight;
        for (int i = 0; i < edges.length; i++) {
            v1 = edges[i][0];
            v2 = edges[i][1];
            weight = succProb[i];
            graph.addEdge(v1, v2, weight);
        }

        return djkstraWithOptimizing(graph, new boolean[n], start, end);

    }

    private static double djkstraWithOptimizing(Graph graph, boolean[] visited, int start, int end) {
        PriorityQueue<double[]> heap = new PriorityQueue<>(Comparator.comparingDouble(o -> -o[1]));
        double[] dist = new double[graph.vertexNum];
        Arrays.fill(dist, 0);
        // start from vertex start.
        // arr[0] -> destination vertex, arr[1] -> weight
        dist[start] = 0;
        heap.offer(new double[]{(double) start, 1L});
        double[] curr;
        int next, des;
        double weight;
        while (!heap.isEmpty()) {
            curr = heap.poll();
            // since a destination vertex will be add multi times to the heap, so we need to check whether the distance
            // of current node is out of date.
            next = (int) curr[0];
            if (curr[1] < dist[next]) { continue; }
            visited[next] = true;

            if (next == end) { continue; }
            // update the distance from collection to a vertex which is not in the collection.
            for (int i = 0; i < graph.adjList[next].size(); i++) {
                des = graph.adjList[next].get(i).v2;
                weight = graph.adjList[next].get(i).weight * curr[1];

                // update the destination and weight.
                if (!visited[des] && dist[des] < weight) {
                    dist[des] = weight;
                    heap.offer(new double[] {(double) des, weight});
                }
            }
        }

        return dist[end];
    }

    public static class Edge {
        private final int v1;
        private final int v2;
        private final double weight;

        public Edge(int v1, int v2, double weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
    }
    public static class Graph {

        private int vertexNum;
        private ArrayList<Edge>[] adjList;

        public Graph(int vertexNum) {
            this.vertexNum = vertexNum;
            adjList = new ArrayList[vertexNum];
            for (int i = 0; i < vertexNum; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        public boolean addEdge(int start, int end, double weight) {
            // undirected graph
            return adjList[start].add(new Edge(start, end, weight)) && adjList[end].add(new Edge(end, start, weight));
        }
    }
}
