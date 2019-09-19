package items;

public class FindMinimumInRotatedSortedArrayII_154 {

    /**
     * Note: because the array is duplicate and rotated, so if the nums[mid] == nums[high], we can not judge where the
     * minimum element lies in. For example:
     * case 1: [3, 1, 3, 3, 3]
     * case 2: [3, 3, 3, 1, 3]
     *
     * So in the worst case, the time complexity is O(n).
     *
     * @param nums input rotated and duplicate array.
     * @return the minimum element.
     */
    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + ((high-low)>>1);
            if (nums[mid] > nums[high]) { low = mid + 1; }
            else if (nums[mid] < nums[high]) { high = mid; }
            else {
                --high;
            }
        }

        return nums[low];
    }
}
