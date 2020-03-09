package items;

import java.util.*;

/**
 * @author hechuan
 */
public class TimeNeededToInformAllEmployees_1376 {

    /**
     * BFS solution to find a maximum sum of each path in a tree.
     *
     * @param n number of nodes
     * @param headID header of the tree/graph
     * @param manager parent nodes array
     * @param informTime weight of each edge
     * @return the minimum time to traverse all nodes
     */
    public static int numOfMinutes1(int n, int headID, int[] manager, int[] informTime) {
        if (manager.length == 0 || manager.length == 1) { return 0; }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }

        int res = 0;
        int[] curr;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {headID, 0});
        while (!queue.isEmpty()) {
            curr = queue.poll();
            res = Math.max(res, curr[1]);
            if (map.get(curr[0]) != null) {
                for (Integer node : map.get(curr[0])) {
                    queue.offer(new int[] {node, curr[1] + informTime[curr[0]]});
                }
            }
        }

        return res;
    }

    /**
     * DFS solution to find a maximum sum of each path in a tree.
     *
     * @param n number of nodes
     * @param headID header of the tree/graph
     * @param manager parent nodes array
     * @param informTime weight of each edge
     * @return the minimum time to traverse all nodes
     */
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (manager.length == 0 || manager.length == 1) { return 0; }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }

        return dfs(headID, map, informTime);
    }

    private int dfs(int headId, Map<Integer, List<Integer>> map, int[] informTime) {
        int max = 0;
        if (map.get(headId) != null) {
            for (Integer node : map.get(headId)) {
                max = Math.max(max, dfs(node, map, informTime));
            }
        }

        return max + informTime[headId];
    }
}
