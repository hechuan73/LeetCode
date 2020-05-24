package items;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeSet;

/**
 * @author hechuan
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit_1438 {

    /**
     * Solution with TreeSet to maintain the maximum and minimum element.
     *
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     *
     * @param nums  input nums
     * @param limit limit number
     * @return the length of longest continuous subarray
     */
    public int longestSubarray1(int[] nums, int limit) {
        TreeSet<Integer> indexes = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
        int res = 1;
        int left = 0, right = 1;
        indexes.add(left);
        while (left < nums.length && right < nums.length) {
            indexes.add(right);
            if (Math.abs(nums[indexes.last()] - nums[indexes.first()]) <= limit) {
                res = Math.max(res, right - left + 1);
                right++;
            } else {
                indexes.remove(left++);
            }
        }

        return res;
    }

    /**
     * Solution with deque to maintain the maximum and minimum element.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums  input nums
     * @param limit limit number
     * @return the length of longest continuous subarray
     */
    public int longestSubarray2(int[] nums, int limit) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        int i = 0, j, res = 0;
        for (j = 0; j < nums.length; j++) {
            while (!max.isEmpty() && nums[j] > max.peekLast()) { max.pollLast(); }
            while (!min.isEmpty() && nums[j] < min.peekLast()) { min.pollLast(); }
            max.offer(nums[j]);
            min.offer(nums[j]);

            if (max.peek() - min.peek() > limit) {
                if (nums[i] == max.peek()) { max.poll(); }
                if (nums[i] == min.peek()) { min.poll(); }
                i++;
            }
            else {
                res = Math.max(res, j-i+1);
            }
        }

        return res;
    }
}