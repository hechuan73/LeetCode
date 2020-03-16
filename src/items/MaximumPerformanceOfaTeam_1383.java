package items;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author hechuan
 */
public class MaximumPerformanceOfaTeam_1383 {

    /**
     * Greedy solution with priority queue.
     * Performance = sum(speed) * min(efficiency). Idea is simple: try every efficiency value from highest to lowest,
     * keep adding speed to total speed, if size of engineers group exceeds K, lay off the engineer with lowest speed.
     *
     * 1. Sort efficiency with descending order. Because, afterwards, when we iterate whole engineers, every round, when
     *    calculating the current performance, minimum efficiency is the efficiency of the new incoming engineer.
     * 2. Maintain a priority queue to track of the minimum speed in the group. If size of group is == K, kick the
     *    engineer with minimum speed out (since efficiency is fixed by new coming engineer, the only thing matters now
     *    is sum of speed).
     * 3. Calculate/Update performance.
     *
     * Time Complexity: O(NlogN)
     * Space Complexity: O(N)
     *
     * @param n number of engineers
     * @param speed speed array of engineers
     * @param efficiency efficiency array of engineers
     * @param k limit k for engineers
     * @return the maximum performance
     */
    public int maxPerformance1(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i] = new int[] {efficiency[i], speed[i]};
        }

        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        long res = Long.MIN_VALUE, speedSum = 0;

        for (int[] engineer : engineers) {
            if (queue.size() == k) { speedSum -= queue.poll(); }
            queue.offer(engineer[1]);
            speedSum += engineer[1];
            res = Math.max(res, speedSum * engineer[0]);
        }

        return (int) (res % 1000000007);
    }

    /**
     * Solution with backtracking.
     * Time Limit Exceeded.
     *
     * @param n number of engineers
     * @param speed speed array of engineers
     * @param efficiency efficiency array of engineers
     * @param k limit k for engineers
     * @return the maximum performance
     */
    public int maxPerformance2(int n, int[] speed, int[] efficiency, int k) {
        backtracking(n, speed, efficiency, k, 0);
        return max;
    }

    int max = 0;
    int speedSum = 0;
    int minEff = Integer.MAX_VALUE;
    private void backtracking(int n, int[] speed, int[] efficiency, int k, int start) {
        if (k == 0 || start == n) { return; }
        int lastMinEff;
        for (int i = start; i < n; i++) {

            speedSum += speed[i];
            lastMinEff = minEff;
            minEff = Math.min(minEff, efficiency[i]);

            long tmp = (speedSum * minEff) % 1000000007;
            max = Math.max(max, (int) tmp);

            backtracking(n, speed, efficiency, k-1, i+1);
            minEff = lastMinEff;
            speedSum -= speed[i];
        }
    }

}
