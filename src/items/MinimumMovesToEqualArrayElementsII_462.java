package items;

import java.util.Arrays;

/**
 * @author hechuan
 */
public class MinimumMovesToEqualArrayElementsII_462 {

    /**
     * This is a mathematical problem. The best solution is moving all element values to value of the median number, so
     * the total steps will be the minimum.
     *
     * If the length of the array is odd, there is only a median number.
     * If the length of the array is even, there are two median number, both of them are ok.
     *
     * Simple Sort solution.
     *
     * Time Complexity: O(nlogn)
     * Space Complexity: O(1)
     *
     * @param nums input array
     * @return the minimum moving steps to make all element values the same.
     */
    public int minMoves2_1(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length/2;
        int res = 0;
        for (int num : nums) {
            res += Math.abs(nums[mid]-num);
        }

        return res;
    }

    /**
     * Optimized Sort solution.
     *
     * Time Complexity: O(nlogn)
     * Space Complexity: O(1)
     *
     * @param nums input array
     * @return the minimum moving steps to make all element values the same.
     */
    public int minMoves2_2(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length-1;
        int res = 0;
        while (start < end) {
            res += nums[end--]-nums[start++];
        }

        return res;
    }

    /**
     * Quick select solution. It is the same as the problem "Find the Kth largest element in an array". We use partition
     * and select method to find the median number which is the Kth largest element in this array, k = nums.length/2.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(logn)
     *
     * @param nums input array
     * @return the minimum moving steps to make all element values the same.
     */
    public int minMoves2_3(int[] nums) {
        int k = nums.length/2;
        int start = 0, end = nums.length-1;
        int pivot;
        while (start < end) {
            pivot = partition(nums, start, end);
            if (pivot == k) { break; }
            else if (pivot < k) { start = pivot+1; }
            else { end = pivot-1; }
        }

        int res = 0;
        for (int num : nums) {
            res += Math.abs(num-nums[k]);
        }
        return res;
    }

    private int partition(int[] nums, int start, int end) {
        int index = start;
        int tmp;
        for (int i = start; i < end; i++) {
            // the pivot is num[end]
            if (nums[i] < nums[end]) {
                tmp = nums[index];
                nums[index++] = nums[i];
                nums[i] = tmp;
            }
        }

        tmp = nums[index];
        nums[index] = nums[end];
        nums[end] = tmp;
        return index;
    }

}
