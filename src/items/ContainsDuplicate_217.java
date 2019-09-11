package items;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate_217 {

    /**
     * Time complexity: O(nlogn)
     * Space complexity: O(1)
     * @param nums input array
     * @return if there are duplicate numbers.
     */
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {return true;}
        }
        return false;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param nums input array
     * @return if there are duplicate numbers.
     */
    public boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);

        for (int num : nums) {
            if (set.contains(num)) { return true;}
            else {set.add(num);}
        }
        return false;
    }
}
