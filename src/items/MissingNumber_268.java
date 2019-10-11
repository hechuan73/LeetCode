package items;

/**
 * @author hechuan
 */
public class MissingNumber_268 {


    /**
     * Using XOR operation.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums input array
     * @return the missing number
     */
    public int missingNumber1(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }

        return res;
    }

    /**
     * use hash method.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums input array
     * @return the missing number
     */
    public int missingNumber2(int[] nums) {
        boolean[] counter = new boolean[nums.length+1];

        for (int num : nums) {
            counter[num] = true;
        }

        for (int i = 0; i < counter.length; i++) {
            if (!counter[i]) { return i; }
        }

        return -1;
    }
}
