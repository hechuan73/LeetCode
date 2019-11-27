package items;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hechuan
 */
public class CourseSchedule_207 {

    /**
     * Simple BFS with in_degrees table to check whether there is a circle in the graph.
     * if the in_degree of a node is 0, we can remove it from the graph by subtract the in_degree of the adjacent nodes
     * with 1. If all nodes can be remove, there is no circle in the graph, otherwise there is one.
     *
     * Time complexity: O(n+m) n: the number of nodes, m: the number of edges. Because we need to traverse all the nodes
     *                  and edges.
     * Complexity: O(n) store the in_degrees tables.
     *
     * @param numCourses the course numbers
     * @param prerequisites the course prerequisites
     * @return whether can finish the course
     */
    public boolean canFinish0(int numCourses, int[][] prerequisites) {

        int[] inDegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) { inDegrees[prerequisite[0]]++; }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) { queue.add(i); }
        }

        int currCourse;
        while (!queue.isEmpty()) {
            currCourse = queue.poll();
            numCourses--;

            // if constructed the graph, dont need to traverse all the prerequisites and will be fast.
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == currCourse && --inDegrees[prerequisite[0]] == 0) { queue.add(prerequisite[0]); }
            }
        }

        return 0 == numCourses;
    }


    /**
     * Improved BFS with in_degrees table and graph adjacent table to check whether there is a circle in the graph.
     *
     * Time complexity: O(n+m) n: the number of nodes, m: the number of edges. Because we need to traverse all the nodes
     *                  and edges.
     * Complexity: O(n+m) store the in_degrees table and edges.
     *
     * @param numCourses the course numbers
     * @param prerequisites the course prerequisites
     * @return whether can finish the course
     */
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < graph.length; i++) { graph[i] = new ArrayList<>(); }

        int[] inDegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
            inDegrees[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        int currCourse, adjCourse;
        while (!queue.isEmpty()) {
            currCourse = queue.poll();
            for (int i = 0; i < graph[currCourse].size(); i++) {
                adjCourse = graph[currCourse].get(i);
                inDegrees[adjCourse]--;
                if(inDegrees[adjCourse] == 0) {
                    queue.add(adjCourse);
                    count++;
                }
            }
        }

        return count == numCourses;
    }



    /**
     * Simple DFS to check whether there is a circle in the graph.
     *
     * Time complexity: O(n+m) n: the number of nodes, m: the number of edges. Because we need to traverse all the nodes
     *                  and edges.
     * Complexity: O(n) store the visited array.
     *
     * @param numCourses the course numbers
     * @param prerequisites the course prerequisites
     * @return whether can finish the course
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        // can not use Arrays.fill(graph, new ArrayList<>()) to init, because the parameter 'new ArrayList<>()' is a
        // reference and will set all graph elements to the reference, so when we change one element, all elements of
        // the graph will be changed.
        for (int i = 0; i < graph.length; i++) { graph[i] = new ArrayList<>(); }

        boolean[] visited = new boolean[numCourses];

        // init graph
        for (int[] prerequisite : prerequisites) { graph[prerequisite[1]].add(prerequisite[0]); }

        for (int i = 0; i < graph.length; i++) {
            if (!canFinish2(graph, visited, i)) { return false; }
        }

        return true;
    }

    private boolean canFinish2(List<Integer>[] graph, boolean[] visited, int course) {
        if (visited[course]) { return false; }
        visited[course] = true;

        for (int i = 0; i < graph[course].size(); i++) {
            if (!canFinish2(graph, visited, graph[course].get(i))) { return false; }
        }
        // reset the visited[course], because we traverse all the downstream elements of the current node, while the
        // current node is not the root node, and there will be other upstream nodes which need to traverse the current
        // node, so we need to reset it.
        visited[course] = false;
        return true;
    }

    /**
     * Improved DFS with a cache array which stores whether it can finish the course from the each course. And then
     * check whether there is a circle in the graph.
     *
     * The cache can prevent revisiting the nodes as well as to deal with cycles.
     *
     * Time complexity: O(n+m) n: the number of nodes, m: the number of edges. Because we need to traverse all the nodes
     *                  and edges.
     * Complexity: O(n) store the visited and cache array.
     *
     * @param numCourses the course numbers
     * @param prerequisites the course prerequisites
     * @return whether can finish the course
     */
    public boolean canFinish3(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        // can not use Arrays.fill(graph, new ArrayList<>()) to init, because the parameter 'new ArrayList<>()' is a
        // reference and will set all graph elements to the reference, so when we change one element, all elements of
        // the graph will be changed.
        for (int i = 0; i < graph.length; i++) { graph[i] = new ArrayList<>(); }

        boolean[] visited = new boolean[numCourses];
        boolean[] cache = new boolean[numCourses];

        // init graph
        for (int[] prerequisite : prerequisites) { graph[prerequisite[1]].add(prerequisite[0]); }


        for (int i = 0; i < graph.length; i++) {
            if (!canFinish3(graph, visited, cache, i)) { return false; }
        }

        return true;
    }

    private boolean canFinish3(List<Integer>[] graph, boolean[] visited, boolean[] cache, int course) {
        if (visited[course]) { return cache[course]; }
        visited[course] = true;

        for (int i = 0; i < graph[course].size(); i++) {
            if (!canFinish3(graph, visited, cache, graph[course].get(i))) {
                cache[course] = false;
                return false;
            }
        }

        // set the cache which means it can finish the course from the index course.
        cache[course] = true;
        return true;
    }
}
