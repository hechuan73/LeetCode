package datastructures.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hechuan
 */
public class Graph {

    private int vertexNum;
    private LinkedList<Integer>[] adjList;

    public Graph(int vertexNum) {
        this.vertexNum = vertexNum;
        adjList = new LinkedList[vertexNum];
        Arrays.fill(adjList, new LinkedList<>());
    }

    public boolean addEdge(int start, int end) {
        // undirected graph
        return adjList[start].add(end) && adjList[end].add(start);
    }

    /**
     * BFS traversal from start vertex to end vertex in a graph.
     *
     * @param start start vertex
     * @param end end vertex
     */
    public void bfsTraversal(int start, int end) {
        if (start != end) {
            boolean[] visited = new boolean[vertexNum];
            visited[start] = true;

            // prev用来存储访问路径
            int[] prev = new int[vertexNum];
            Arrays.fill(prev, -1);

            // queue用来存储已经被访问，但相邻的顶点还没有被访问的顶点
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);

            // 当前顶点和其邻接顶点
            int curr, adjVertex;
            while (!queue.isEmpty()) {
                curr = queue.poll();
                for (int i = 0; i < adjList[curr].size(); i++) {
                    adjVertex = adjList[curr].get(i);
                    if (!visited[adjVertex]) {
                        prev[adjVertex] = curr;
                        // 到达终点
                        if (adjVertex == end) {
                            print(prev, start, end);
                            return;
                        }
                        visited[adjVertex] = true;
                        queue.add(adjVertex);
                    }
                }
            }
        }
    }

    private boolean found = false;

    /**
     * DFS traversal from start vertex to end vertex in a graph.
     *
     * @param start start vertex
     * @param end end vertex
     */
    private void dfsTraversal(int start, int end) {
        found = false;
        boolean[] visited = new boolean[vertexNum];
        int[] prev = new int[vertexNum];
        Arrays.fill(prev, -1);
        dfs(start, end, visited, prev);
        print(prev, start, end);
    }

    private void dfs(int start, int end, boolean[] visited, int[] prev) {
        if (!found) {
            visited[start] = true;
            if (start == end) {
                found = true;
                return;
            }

            int adjVertex;
            for (int i = 0; i < adjList[start].size(); i++) {
                adjVertex = adjList[start].get(i);
                if (!visited[adjVertex]) {
                    prev[adjVertex] = start;
                    dfs(adjVertex, end, visited, prev);
                }
            }
        }
    }

    private void print(int[] prev, int start, int end) {
        if (prev[end] != -1 && end != start) {
            print(prev, start, prev[end]);
        }
        System.out.println(end + " ");
    }



}
