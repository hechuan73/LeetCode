package items;

import java.util.Arrays;

public class ThreeSumClosest_16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int temBalance = Integer.MAX_VALUE, balance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int second = i + 1, third = nums.length - 1;

            while (second < third) {
                int sum = nums[i] + nums[second] + nums[third];
                if (sum == target) return target;
                else if (sum > target) third--;
                else second++;

                if (Math.abs(temBalance) > Math.abs(sum - target))
                    temBalance = sum - target;
            }

            if (Math.abs(temBalance) <= Math.abs(balance))
                balance = temBalance;
            else break;
        }

        return target + balance;
    }
}
