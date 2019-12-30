package items;

/**
 * @author hechuan
 */
public class JumpGameIII_1306 {

    /**
     * Backtracking with cache.
     *
     * @param arr input array
     * @param start the index to start
     * @return whether it can reach the index of element value with 0.
     */
    public boolean canReach(int[] arr, int start) {
        return visit(arr, start, new boolean[arr.length], new boolean[arr.length]);
    }

    private boolean visit(int[] arr, int start, boolean[] visited, boolean[] reached) {
        if (arr[start] == 0) { return true; }
        if (visited[start]) { return reached[start]; }

        visited[start] = true;
        int index = start+arr[start];
        if (index < arr.length) { reached[start] = visit(arr, index, visited, reached); }
        if (reached[start]) { return true; }

        index = start-arr[start];
        if (index >= 0) { reached[start] = visit(arr, start-arr[start], visited, reached); }

        return reached[start];
    }
}
