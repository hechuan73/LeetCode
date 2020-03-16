package algorithms.minimumpath;

import java.util.Scanner;

/**
 * 主要流程：
 * 用edge表示边，dist[i]表示起点距离点i的最短路径。
 * ​1. 定义两个集合，一个集合A表示已经找到最短路的集合，另一个B没有，一开始集合A中只有起点一个元素，集合B则含有其他的所有点。
 * 2. 从B集合中选择一个直接连向起点，且距离起点最近的点,以下记作i
 * 3. 将这个点从集合B中删去，加入集合A中，并用这个点更新所有点到起点的距离dis[j] = min(dis[j], dis[j] + edge.weight)。
 * 4. 重复前面的操作直到B集合为空。
 *
 * Time Complexity：O(n2)
 * Space Complexity: O(n2)
 *
 * 注：可以求解单源点到其他点的最短路径问题。同时不能处理权值为负数的情况。
 *
 *
 * @author hechuan
 */
public class Dijkstra {

    public static int dijkstra(int start, int end) {
        Scanner scanner = new Scanner(System.in);
        int node = scanner.nextInt();
        int edge = scanner.nextInt();

        int[][] map = new int[node + 1][node + 1];
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
        return dijkstra(map, new boolean[node + 1], start)[end];
    }

    public static int[] dijkstra(int[][] map, boolean[] visited, int start) {
        int[] dist = new int[visited.length];
        System.arraycopy(map[start], 0, dist, 0, map[start].length);

        visited[start] = true;
        int minDist, next;
        for (int i = 1; i < dist.length; i++) {
            minDist = Integer.MAX_VALUE;
            next = 0;

            for (int j = 1; j < dist.length; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    next = j;
                }
            }

            for (int j = 1; j < dist.length; j++) {
                dist[j] = Math.min(dist[j], dist[next] + map[next][j]);
            }
        }

        return dist;
    }
}
