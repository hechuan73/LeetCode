package items;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hechuan
 */
public class MinimumCostToHireKWorkers_857 {

    /**
     * Greedy solution with priority queue.
     *
     * Let's read description first and figure out the two rules:
     *
     * 1. Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the
     * paid group.
     *     So for any two workers in the paid group,
     *     we have wage[i] : wage[j] = quality[i] : quality[j]
     *     So we have wage[i] : quality[i] = wage[j] : quality[j]
     *     We pay wage to every worker in the group with the same ratio compared to his own quality.
     *
     * 2. Every worker in the paid group must be paid at least their minimum wage expectation.
     *     For every worker, he has an expected ratio of wage compared to his quality. So to minimize the total wage, we
     *     want a small ratio. So we sort all workers with their expected ratio, and pick up K first worker. Now we have
     *     a minimum possible ratio for K worker and we their total quality.
     *
     *     As we pick up next worker with bigger ratio, we increase the ratio for whole group. Meanwhile we remove a
     *     worker with highest quality so that we keep K workers in the group. We calculate the current ratio * total
     *     quality = total wage for this group.
     *
     * We redo the process and we can find the minimum total wage. Because workers are sorted by ratio of wage/quality.
     * For every ratio, we find the minimum possible total quality of K workers.
     *
     * Time Complexity
     * O(NlogN) for sort.
     * O(NlogK) for priority queue.
     *
     * @param quality quality array of workers
     * @param wage wage array of workers
     * @param K the limit of works
     * @return the minimum cost to hire workers
     */
    public static double minCostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        double[][] workers = new double[n][2];

        for (int i = 0; i < n; i++) {
            workers[i] = new double[] {(double) wage[i] / quality[i], quality[i]};
        }

        Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));
        PriorityQueue<Double> queue = new PriorityQueue<>();
        double res = Double.MAX_VALUE, costSum = 0;
        int qualitySum = 0;
        int[] peek;
        for (double[] worker : workers) {
            qualitySum += worker[1];
            queue.offer(-worker[1]);
            if (queue.size() > K) { qualitySum += queue.poll(); }
            if (queue.size() == K) { res = Math.min(res, qualitySum * worker[0]); }
        }

        return res;
    }
}
