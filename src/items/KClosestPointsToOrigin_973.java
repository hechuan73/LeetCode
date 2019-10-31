package items;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author hechuan
 */
public class KClosestPointsToOrigin_973 {

    /**
     * Using recursive partition
     *
     * Time Complexity: O(N) : Best/Average O(N), Worst O(n2)
     * Space Complexity: O(1)
     *
     * @param points input arrays
     * @param K the Kth
     * @return the Kth closest points.
     */
    public int[][] kClosest(int[][] points, int K) {
        int left = 0, right = points.length-1;
        while (left < right) {
            int pivot = partition(points, left, right);
            if (pivot == K) { break; }
            else if (pivot < K) { left = pivot + 1;}
            else { right = pivot - 1;}
        }

        return Arrays.copyOfRange(points, 0, K);
    }

    private int partition(int[][] nums, int start, int end) {
        int index = start;
        for (int i = start; i < end; i++) {
            // the pivot is num[end]
            if (compare(nums[i], nums[end]) < 0) {
                int[] tmp = nums[index];
                nums[index++] = nums[i];
                nums[i] = tmp;
            }
        }

        int[] tmp = nums[index];
        nums[index] = nums[end];
        nums[end] = tmp;
        return index;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0]*p1[0]+p1[1]*p1[1] - p2[0]*p2[0]-p2[1]*p2[1];
    }


    /**
     * Using heap sort
     *
     * Time Complexity: O(NlogK)
     * Space Complexity: O(K)
     *
     * @param points input arrays
     * @param K the Kth
     * @return the Kth closest points.
     */
    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<int[]> bigTopHeap = new PriorityQueue<>(K, (w1, w2) ->
                (w2[0]*w2[0] + w2[1]*w2[1]) - (w1[0]*w1[0] + w1[1]*w1[1]));

        for (int[] point : points) {
            bigTopHeap.offer(point);
            if (bigTopHeap.size() > K) { bigTopHeap.poll(); }
        }

        int[][] res = new int[K][];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = bigTopHeap.poll();
        }

        return res;
    }

    /**
     * Using quick sort
     *
     * Time Complexity: O(NlogN)
     * Space Complexity: O(1)
     *
     * @param points input arrays
     * @param K the Kth
     * @return the Kth closest points.
     */
    public int[][] kClosest3(int[][] points, int K) {
        Arrays.sort(points, (w1, w2) ->
                (w2[0]*w2[0] + w2[1]*w2[1]) - (w1[0]*w1[0] + w1[1]*w1[1]));

        return Arrays.copyOfRange(points, 0, K);
    }


}
