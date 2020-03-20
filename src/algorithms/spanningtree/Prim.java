package algorithms.spanningtree;

import java.util.*;

/**
 * 基本思想是对图G(V,E)设置集合S来存放已被访问的顶点，然后执行n次下面两个步骤(n为顶点数目)：
 * 1. 每次从集合V-S中选择与集合S最近的一个顶点，记为u,将u加入到S中，同时把这条离集合S最近的边加入到最小生成树中。
 * 2. 令顶点u作为集合S与集合V-S连接的接口，优化从u能到达的未访问顶点v与集合S的最短距离。
 *
 * Time Complexity: O(NlogN) -> 主要耗时在遍历所有节点，适合稠密图顶点少，边多的场景。
 * Space Complexity: O(N+E)
 *
 * 实现：1. 基本思路是使用邻接矩阵存储图，每次遍历所有未访问的节点，寻找离集合S最近的点，加入集合，然后通过该点优化未访问的点离集合的距离。
 *      2. 由于每次遍历所有未访问的节点，寻找离集合S最近的点比较耗时，考虑使用堆来进行优化这一部分。同时整个算法采用邻接表来存储整个图
 *
 * @author hechuan
 */
public class Prim {

    /**
     * Using the adjacent matrix to save the graph.
     *
     * @return the weight of minimum spanning tree
     */
    public static int prim() {
        Scanner scanner = new Scanner(System.in);
        int node = scanner.nextInt();
        int edge = scanner.nextInt();

        int[][] map = new int[node+1][node+1];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }

        int v1, v2, weight;
        for (int i = 0; i < edge; i++) {
            v1 = scanner.nextInt();
            v2 = scanner.nextInt();
            weight = scanner.nextInt();
            map[v1][v2] = weight;
            map[v2][v1] = weight;
        }

        scanner.close();
        return prim(map, new boolean[node+1]);
    }


    private static int prim(int[][] map, boolean[] visited) {
        // default start point is vertex 1.
        int start = 1, spanningPathWeightSum = 0;
        // the minimum dist from the vertexes collection to a vertex which is not in the collection.
        // at the first, the collection only has one vertex which is the start vertex.
        int[] dist = new int[visited.length];
        // init the distant from start vertex to other vertexes.
        if (dist.length - 1 >= 0) { System.arraycopy(map[start], 1, dist, 1, dist.length - 1); }

        visited[start] = true;
        int next, minDist;
        for (int i = 1; i < dist.length; i++) {
            next = 0;
            minDist = Integer.MAX_VALUE;

            // find the minimum distance vertex from the collection to a vertex which is not in the collection.
            // here we need to traverse all vertex unvisited, so it can be optimised with heap.
            for (int j = 1; j < dist.length; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    next = j;
                    minDist = dist[j];
                }
            }

            // add it to the spanning tree.
            spanningPathWeightSum += minDist;
            // set it  visited
            visited[next] = true;
            // update the distance from the collection to a vertex which is not in the collection.
            for (int j = 1; j < dist.length; j++) {
                if (!visited[j] && dist[j] > map[next][j]) {
                    dist[j] = map[next][j];
                }
            }
        }

        return spanningPathWeightSum;
    }

    /**
     * Using heap to optimize each time we find the vertex which is closest to the visited vertex collection.
     *
     * Using the adjacent list to save the graph.
     *
     * @return the weight of minimum spanning tree
     */
    private static int primWithHeap() {
        Scanner scanner = new Scanner(System.in);
        int node = scanner.nextInt();
        int edge = scanner.nextInt();

        Graph graph = new Graph(node);
        int v1, v2, weight;
        for (int i = 0; i < edge; i++) {
            v1 = scanner.nextInt();
            v2 = scanner.nextInt();
            weight = scanner.nextInt();
            graph.addEdge(v1, v2, weight);
        }

        scanner.close();
        return primWithHeap(graph, new boolean[graph.vertexNum+1]);
    }

    private static int primWithHeap(Graph graph, boolean[] visited) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] dist = new int[graph.vertexNum+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // start from vertex 1.
        dist[1] = 0;
        // arr[0] -> destination vertex, arr[1] -> weight
        heap.offer(new int[]{1, 0});
        int spanningTreePathWeightSum = 0;
        int[] curr;
        int des, weight;
        while (!heap.isEmpty()) {
            curr = heap.poll();
            // since a destination vertex will be add multi times to the heap, so we need to check whether the distance
            // of current node is out of date.
            if (curr[1] > dist[curr[0]]) { continue; }
            visited[curr[0]] = true;
            spanningTreePathWeightSum += curr[1];
            // update the distance from collection to a vertex which is not in the collection.
            for (int i = 0; i < graph.adjList[curr[0]].size(); i++) {
                des = graph.adjList[curr[0]].get(i).v2;
                weight = graph.adjList[curr[0]].get(i).weight;

                // update the destination and weight.
                if (!visited[des] && dist[des] > weight) {
                    dist[des] = weight;
                    heap.offer(new int[] {des, weight});
                }
            }

        }

        return spanningTreePathWeightSum;
    }

    public static class Edge {
        private final int v1;
        private final int v2;
        private final int weight;

        public Edge(int v1, int v2, int weight) {
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
            Arrays.fill(adjList, new ArrayList<>());
        }

        public boolean addEdge(int start, int end, int weight) {
            // undirected graph
            return adjList[start].add(new Edge(start, end, weight)) && adjList[end].add(new Edge(end, start, weight));
        }
    }
}
