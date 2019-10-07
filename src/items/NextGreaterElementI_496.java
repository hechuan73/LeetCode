package items;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI_496 {

    /**
     * General solution for the next greater elements problems using monotone stake.
     *
     * Note: if the stack stores the index instead of value, we can traverse rightly to reduce operations.
     *
     * @param nums input array
     * @return the next greater elements array
     */
    public int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        // traversing with the reverse order.
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i]) {
                // delete the small one.
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return res;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        // store the next great element for elements in array nums2.
        Map<Integer, Integer> nextGreaterNums = new HashMap<>(nums2.length);
        Stack<Integer> stack = new Stack<>();

        // traversing with the right direction to reduce operations.
        for (int num : nums2) {
            while (!stack.empty() && stack.peek() < num) {
                nextGreaterNums.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) { res[i] = nextGreaterNums.getOrDefault(nums1[i], -1); }

        return res;
    }
}
