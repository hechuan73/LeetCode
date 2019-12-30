package items;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author hechuan
 */
public class ShortestUnsortedContinuousSubarray_581 {

    /**
     * Using sorting with extra array space.
     *
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     *
     * @param nums input array
     * @return the unsorted subarray
     */
    public int findUnsortedSubarray1(int[] nums) {
        int start = -1, end = nums.length-1;
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != tmp[i]) {
                start = i;
                break;
            }
        }
        if (start == -1) { return 0; }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != tmp[i]) {
                end = i;
                break;
            }
        }

        return end-start+1;
    }

    /**
     * Using stack to find the start and end index, same as the next greater number question.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums input array
     * @return the unsorted subarray
     */
    public int findUnsortedSubarray2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int start = nums.length, end = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                start = Math.min(start, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                end = Math.max(end, stack.pop());
            }
            stack.push(i);
        }

        return end > start ? end-start+1 : 0;
    }

    /**
     * Find the maximum and minimum number in the unsorted area, and traverse the array and compare.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums input array
     * @return the unsorted subarray
     */
    public int findUnsortedSubarray3(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        // find the minimum number in the unsorted area.
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) { flag = true; }
            if (flag) { min = Math.min(min, nums[i]); }
        }

        flag = false;
        // find the maximum number in the unsorted area.
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) { flag = true; }
            if (flag) { max = Math.max(max, nums[i]); }
        }

        int start, end;
        // determine the start index of the unsorted area.
        for (start = 0; start < nums.length; start++) {
            if (nums[start] > min) { break; }
        }

        // determine the end index of the unsorted area.
        for (end = nums.length - 1; end >= 0; end--) {
            if (nums[end] < max) { break; }
        }

        return end > start ? end-start+1 : 0;
    }
}
