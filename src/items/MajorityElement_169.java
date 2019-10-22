package items;

import java.util.Arrays;

/**
 * @author hechuan
 */
public class MajorityElement_169 {

    /**
     * Approach 1: Boyer-Moore Voting Algorithm.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums input array
     * @return the major element
     */
    public int majorityElement1(int[] nums) {
        int candidate = nums[0];
        int counter = 0;

        for (int num : nums) {
            if (counter == 0) { candidate = num; }
            counter += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    /**
     * Approach 2: Sorting and select the mid value.
     *
     * Time Complexity: O(nlogn)
     * Space Complexity: O(1)
     *
     * @param nums input array
     * @return the major element
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
