package items;

import java.util.*;

/**
 * @author hechuan
 */
public class CourseScheduleII_210 {

    /**
     * Topological sort by check in-degrees(BFS). Calculate the in-degrees of all vertexes, and firstly visit the
     * vertexes whose in-degrees is 0, which means these vertexes dont dependent on any vertexes. When we visited one
     * vertex, delete it by subtract the in-degrees of all vertex it can reach. Finally, if there are also some vertexes
     * that their in-degrees are not 0, there is a cycle in the graph.
     *
     * @param numCourses number of courses
     * @param prerequisites the prerequisites of courses
     * @return the order of course studying
     */
    public static int[] findOrder1(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] inDegrees = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            inDegrees[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) { queue.add(i); }
        }

        int curr, index = 0;
        while (!queue.isEmpty()) {
            curr = queue.remove();
            res[index++] = curr;
            numCourses--;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == curr && --inDegrees[prerequisite[0]] == 0) { queue.add(prerequisite[0]); }
            }
        }

        return numCourses == 0 ? res : new int[0];
    }

    /**
     * DFS. Firstly visit all the vertexes that the current vertex depends on and then visit the current vertex. Note we
     * need to check if there is a cycle in the graph. So we use a visited array to check it. Previously we use a bool
     * array to record which vertex we have visited, if we use it in one loop search (for specific origination and
     * destination), it is useful. But when we traverse in the graph instead of searching a specific path, different
     * searching loops will affect each other. So we use an integer array to represent different states:
     * 0 means not visited
     * 1 means visiting
     * 2 means visited
     *
     * So in the dfs process，if the previous vertexes is visiting, and we visit it again, it means there is a cycle in
     * the graph.
     *
     * @param numCourses number of courses
     * @param prerequisites the prerequisites of courses
     * @return the order of course studying
     */
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] inverseAdj = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++) { inverseAdj[i] = new LinkedList<>(); }

        // inverseAdj[i] = j, means i depends on j, we need visit j firstly.
        for (int[] prerequisite : prerequisites) { inverseAdj[prerequisite[0]].add(prerequisite[1]); }

        int[] visited = new int[numCourses];

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, inverseAdj, visited, ans)) { return new int[0]; }
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < ans.size(); i++) { res[i] = ans.get(i); }
        return res;
    }

    public static boolean dfs(int vertex, LinkedList<Integer>[] inverseAdj, int[] visited, List<Integer> ans) {
        if (visited[vertex] == 1) { return false; }
        if (visited[vertex] == 2) { return true; }
        visited[vertex] = 1;
        for (Integer index : inverseAdj[vertex]) {
            if (!dfs(index, inverseAdj, visited, ans)) { return false; }
        }

        visited[vertex] = 2;
        ans.add(vertex);
        return true;
    }
}
