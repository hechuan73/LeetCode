package items;

/**
 * @author hechuan
 */
public class MinimumSizeSubarraySum_209 {

    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, res = Integer.MAX_VALUE;
        int sum = 0;
        // if we eventually check the res == Integer.MAX_VALUE, it will ignore the case: s = Integer.MAX_VALUE, and nums
        // contains Integer.MAX_VALUE "1", so we use a flag.
        boolean flag = false;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                flag = true;
                res = Math.min(res, right-left+1);
                sum -= nums[left++];
            }
            right++;
        }

        return flag ? res : 0;
    }
}
