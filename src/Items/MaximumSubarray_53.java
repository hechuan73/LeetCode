package Items;

public class MaximumSubarray_53 {



    /**
     * =========================================================================================================
     * There are two solutions, the second one is more subtle, while the first one is faster in most situations.
     * =========================================================================================================
     *
     * Approach 1: Dynamic Programming
     *     The continuous subarray will end with its sum less than 0. So we record each subarray's sum and find the
     *     largest as the solution.
     *
     * Time complexity: O(n).
     *
     * @param nums input array.
     * @return the sum of the continuous subarray (containing at least one number) which has the largest sum.
     */
    public static int maxSubArray1(int[] nums) {
        int sum = nums[0], maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    /**
     * Approach 2: Divide and Conquer.
     *     Divide the array into two subarray, and find the largest sum in two part. Then begin with the mid element,
     *     extend towards the two ends of the subarray and record its sum. Compare the three value to get to largest one
     *     as the solution.
     * @param nums input array.
     * @return the sum of the continuous subarray (containing at least one number) which has the largest sum.
     */
    public static int maxSubArray2(int[] nums) {
        return maxPart(nums, 0, nums.length - 1);
    }

    private static int maxPart(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = (left + right) / 2;
        return Math.max(maxPart(nums, left, mid),
                Math.max(maxMidExtend(nums, left, mid, right),
                        maxPart(nums, mid + 1, right)));
    }

    private static int maxMidExtend(int[] nums, int left, int mid, int right) {
        int sum = 0, leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;

        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }


}
