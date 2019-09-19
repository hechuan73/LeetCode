package algorithms.search;

/**
 * @author hechuan
 */
public class BinarySearch {

    /**
     * Basic: Find the element which is equal to the target value from the sorted and no-duplicate array.
     *
     * @param nums input array
     * @param target target value
     * @return the index of the element
     */
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while (low <= high) {
            int mid = low + ((high-low)>>1);
            if (nums[mid] == target) { return mid; }
            else if (nums[mid] < target) { low = mid + 1; }
            else { high = mid - 1; }
        }

        return -1;
    }

    /**
     * Advanced 1: Find the first element which is equal to the target value from the sorted and duplicate array.
     *
     * @param nums input array
     * @param target target value
     * @return the index of the element
     */
    public int search1(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while (low <= high) {
            int mid = low + ((high-low)>>1);

            if (nums[mid] > target) { high = mid - 1; }
            else if (nums[mid] < target) { low = mid + 1; }
            else {
                if (mid == 0 || nums[mid-1] != target) { return mid; }
                else { high = mid - 1; }
            }
        }

        return -1;
    }

    /**
     * Advanced 2: Find the last element which is equal to the target value from the sorted and duplicate array.
     *
     * @param nums input array
     * @param target target value
     * @return the index of the element
     */
    public int search2(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while (low <= high) {
            int mid = low + ((high-low)>>1);

            if (nums[mid] > target) { high = mid - 1; }
            else if (nums[mid] < target) { low = mid + 1; }
            else {
                if (mid == nums.length-1 || nums[mid+1] != target) { return mid; }
                else { low = mid + 1; }
            }
        }

        return -1;
    }

    /**
     * Advanced 3: Find the first element which is greater than or equal to the target value from the sorted array.
     *
     * @param nums input array
     * @param target target value
     * @return the index of the element
     */
    public int search3(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while (low <= high) {
            int mid = low + ((high-low)>>1);

            if (nums[mid] < target) { low = mid + 1; }
            else {
                if (mid == 0 || nums[mid-1] < target) { return mid; }
                else { high = mid - 1; }
            }
        }

        return -1;
    }

    /**
     * Advanced 3: Find the last element which is less than or equal to the target value from the sorted array.
     *
     * @param nums input array
     * @param target target value
     * @return the index of the element
     */
    public int search4(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while (low <= high) {
            int mid = low + ((high-low)>>1);

            if (nums[mid] > target) { high = mid - 1; }
            else {
                if (mid == nums.length-1 || nums[mid+1] > target) { return mid; }
                else { low = mid + 1; }
            }
        }

        return -1;
    }

    /**
     * Advanced 5: Find the element which is equal to the target value from the rotated (the cycle ) order and
     * no-duplicate array.
     * For the rotated or cycle sorted array, just like: [4, 5, 6, 7, 1, 2, 3].
     *
     * @param nums input array
     * @param target target value
     * @return the index of the element
     */
    public int search5(int[] nums, int target) {

        // 1. find the rotation point by binary search.
        // 2. check which part the target value lies in (the former part or the later part)
        // 3. find the target element by binary search.
        // More details see the class 'SearchInRotatedSortedArray_33'.

        return -1;
    }
}
