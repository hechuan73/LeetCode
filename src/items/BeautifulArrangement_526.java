package items;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hechuan
 */
public class BeautifulArrangement_526 {

    /**
     * Simple backtracking.
     *
     * @param N input range N
     * @return the amount of qualified arrangements
     */
    public int countArrangement1(int N) {
        return backtracking1(N, 1, new boolean[N]);
    }

    private int backtracking1(int n, int length, boolean[] visited) {
        if (length > n) { return 1; }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i-1] && (i % length == 0 || length % i == 0)) {
                visited[i-1] = true;
                res += backtracking1(n, length+1, visited);
                visited[i-1] = false;
            }
        }

        return res;
    }

    /**
     * Optimised backtracking with cache. If without cache, there are many duplicated sub-problems. For example, N = 10,
     * index 1 choose 4 and 2 choose 8 vs 1 choose 8 and 2 choose 4, the left sub-problem is overlapped. So we use a map
     * and array to cache the current status. For example, index 1 choose 4 and 2 choose 8, the array currState will be
     * "fffftffftff", we cache "fffftffftff" as a key in the map, so next index 1 choose 8 and 2 choose 4, it has been
     * calculated, we can return the answer directly.
     *
     * @param N input range N
     * @return the amount of qualified arrangements
     */
    public static int countArrangement2(int N) {
        // cache current status of all number whether them are selected.
        char[] currState = new char[N + 1];
        // f means not selected, t means selected
        Arrays.fill(currState, 'f');
        return backtracking2(new HashMap<String, Integer>(), currState, 1);
    }

    public static int backtracking2(Map<String, Integer> map, char[] currState, int index) {
        if(index == currState.length) { return 1; }
        // current status may be "f f t t t f f"...
        String key = String.valueOf(currState);
        if(map.containsKey(key)) { return map.get(key); }

        int count = 0;
        for(int i = 1; i < currState.length; i++) {
            if(currState[i] == 'f' && (i % index == 0 || index % i == 0)) {
                currState[i] = 't';
                count += backtracking2(map, currState, index + 1);
                currState[i] = 'f';
            }
        }

        map.put(key, count);
        return count;
    }

}
