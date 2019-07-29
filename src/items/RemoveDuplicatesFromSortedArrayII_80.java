package items;


public class RemoveDuplicatesFromSortedArrayII_80 {
    /**
     * The two pointers i and num start at the same time and point to a position. When the current value does not need
     * to be larger than the previous one, it means that 3 are present.Or more than 3 same values, at this time the if
     * condition is not satisfied, i stays in the unsatisfied position, waiting for the next larger number to be
     * replaced, when the next larger one appears.
     *
     * The number again satisfies the if condition, replacing the position pointed to by i with the number, i pointing
     * to the next waiting for replacement, and the if condition is again used to detect the replacement.
     *
     * The number is guaranteed to not appear more than two repetitions.
     *
     *
     * Note: This solution can be easily generalized to "at most K duplicates"!
     *      int removeDuplicates(vector<int>& nums, int k) {
     *          int i = 0;
     *          for (int n : nums)
     *              if (i < k || n > nums[i-k])
     *                  nums[i++] = n;
     *              return i;
     *          }
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;

        for (int num : nums) {
            if (i < 2 || num > nums[i-2]) nums[i++] = num;
        }

        return i;
    }
//    public static int removeDuplicates(int[] nums) {
//        int length;
//        if ((length = nums.length) == 0) return 0;
//        if (length == 1) return 1;
//        int count = 1, result = 1;
//
//        for (int i = length-2; i >= 0 ; i--) {
//            if (nums[i] == nums[i+1]) count++;
//            else {
//                if (count > 2) {
//                    int value = count - 2;
//                    System.arraycopy(nums, i+value+1, nums, i+1, length-i-1-value);
//                    result -= value;
//                }
//                count = 1;
//            }
//            result++;
//        }
//
//        if (count > 2) {
//            int value = count - 2;
//            System.arraycopy(nums, value, nums, 0, length-value);
//            result -= value;
//        }
//
//        return result;
//    }
}
