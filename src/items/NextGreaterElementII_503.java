package items;

import java.util.Stack;

public class NextGreaterElementII_503 {

    /**
     * Because the input array is circular, if we traverse one time, we can just get the result of the single
     * direction array, which contains some error elements for the circular array, so we need to traverse the second
     * time to revise the error elements in the result array.
     *
     * Moreover, we use the '%' operation to turn the direction smoothly.
     *
     * @param nums the input circular array
     * @return the next greater elements array
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2*nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }

        return res;
    }
}
