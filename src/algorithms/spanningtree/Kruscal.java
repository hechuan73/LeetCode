package algorithms.spanningtree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Kruscal 采用边贪心的策略，基本思想是：在初始状态时隐去图中所有的边，这样图中每个顶点都自成一个连通块。之后执行下面的步骤：
 * 1. 将所有边按边权从小到大进行排序。
 * 2. 按边权从小到大测试所有边，如果当前测试的边的两个顶点不在同一个连通块内，就把这条边加入到最小生成树中；否则，将该边舍弃。
 * 3. 执行步骤2直至最小生成树中的边数等于总顶点数减一或是测试完所有边时结束。
 *
 * Time Complexity: O(ElogE) -> 主要耗时在边权重的排序上，适合稀疏图顶点多，边少的场景。
 * Space Complexity: O(N+E)
 * 实现：使用并查集来判断两个定点是否在一个连通图内（是否具有公共祖先），将边用List存储即可。
 *
 * @author hechuan
 */
public class Kruscal {

    public static int kruscal() {
        Scanner scanner = new Scanner(System.in);
        int node = scanner.nextInt();
        int edge = scanner.nextInt();

        int[] nodes = new int[node+1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = i;
        }

        List<Edge> edges = new ArrayList<>();
        int v1, v2, weight;
        for (int i = 0; i < edge; i++) {
            v1 = scanner.nextInt();
            v2 = scanner.nextInt();
            weight = scanner.nextInt();
            edges.add(new Edge(v1, v2, weight));
        }
        scanner.close();

        return kruscal(nodes, edges);
    }

    private static int kruscal(int[] nodes, List<Edge> edges) {
        edges.sort(Comparator.comparingInt(o -> o.weight));

        int minimumWeightSum = 0, count = 0;
        for (Edge edge : edges) {
            if (merge(edge.v1, edge.v2, nodes)) {
                minimumWeightSum += edge.weight;
                count++;
            }
            // nodes.length = n+1, n is the number of vertexes, the minimum spanning tree has n-1 edges.
            if (count == nodes.length-2) { break; }
        }

        return minimumWeightSum;
    }

    private static int getAncestor(int v, int[] nodes) {
        return nodes[v] == v ? v : getAncestor(nodes[v], nodes);
    }

    private static boolean merge(int v1, int v2, int[] nodes) {
        if (getAncestor(v1, nodes) == getAncestor(v2, nodes)) { return false; }
        nodes[v2] = v1;
        return true;
    }

    public static class Edge {
        private int v1;
        private int v2;
        private int weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
    }
}
