package items;

import java.util.Arrays;

/**
 * @author hechuan
 */
public class MaximumProductSubarray_152 {

    /**
     * This problem is a dp question. But the state is depends on four state:
     * 1. nums[i]
     * 2. nums[i] * currMax (currMax means the maximum product up to the current element)
     * 3. nums[i] * currMin (currMax means the maximum product up to the current element)
     * 4. dp[i-1] (dp[i] means when up to the element elements[i], the maximum product value)
     *
     * Note that the dp[i] dont acquire the the last element is the current element, but the calculation of currMin and
     * currMax is up to the current element.
     *
     * because the dp[i] store the maximum result up to the elements[i], we can simplify to use a variable instead of a
     * dp array for the solution below.
     *
     * @param nums input array
     * @return the max product of subarray
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }

        int res = nums[0];
        int max = nums[0], min = nums[0];
        int[] tmp;
        for (int i = 1; i < nums.length; i++) {
            tmp = new int[]{nums[i], nums[i]*max, nums[i]*min};
            Arrays.sort(tmp);
            res = Math.max(res, tmp[2]);
            min = tmp[0];
            max = tmp[2];
        }

        return res;
    }
}
