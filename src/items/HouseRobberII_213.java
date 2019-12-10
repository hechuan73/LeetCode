package items;

/**
 * @author hechuan
 */
public class HouseRobberII_213 {

    /**
     * Simple iterative dp with an array cache: f(n) = Math.max(nums[n] + f(n - 2), f(n - 1)).
     * Note that the street is cycle, so if we start from the first house, we need to stop at the (N-1)th house. If we
     * start from the second house, we need to stop at the Nth house. So create two dp processes, and compare the last
     * stage of them.
     *
     * @param nums input array
     * @return the maximum rob value
     */
    public int rob(int[] nums) {
        if (nums.length == 0) { return 0; }
        if (nums.length == 1) { return nums[0]; }
        if (nums.length == 2) { return Math.max(nums[0], nums[1]); }

        int[] dpFromFirstHouse = new int[nums.length+1];
        dpFromFirstHouse[1] = nums[0];
        int[] dpFromSecondHouse = new int[nums.length+1];
        for (int i = 1; i < nums.length; i++) {
            dpFromFirstHouse[i+1] = Math.max(dpFromFirstHouse[i], dpFromFirstHouse[i-1]+nums[i]);
            dpFromSecondHouse[i+1] = Math.max(dpFromSecondHouse[i], dpFromSecondHouse[i-1]+nums[i]);
        }

        return Math.max(dpFromFirstHouse[nums.length-1], dpFromSecondHouse[nums.length]);
    }
}
