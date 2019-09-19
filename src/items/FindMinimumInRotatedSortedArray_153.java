package items;


/**
 * @author hechuan
 */
public class FindMinimumInRotatedSortedArray_153 {

    /**
     * Note: we need to compare nums[mid] and nums[high] rather than nums[mid] and nums[mid+1]
     *
     * @param nums the input rotated array
     * @return the smallest element
     */
    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + ((high-low)>>1);
            if (nums[mid] > nums[high]) { low = mid + 1; }
            else { high = mid; }
        }

        return nums[low];
    }
}
