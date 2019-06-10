package Items;

public class SearchInRotatedSortedArrayII_81 {

    /**
     * The solution can apply both the nums is a duplicated array and not.
     * @param nums input array
     * @param target target value
     * @return true if find the result
     */
    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) return true;

            if (nums[mid] < nums[right] || nums[mid] < nums[left]) {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            } else if (nums[mid] > nums[left] || nums[mid] > nums[right]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else left++;
        }

        return false;
    }
//    public static boolean search(int[] nums, int target) {
//        if (nums.length == 0) return false;
//        int left = 0, right = nums.length - 1;
//
//
//        while (left < right && nums[left] == nums[right] ) {
//            if (nums[left] == target) return true;
//            left++;
//        }
//
//        if (nums[left] > nums[right]) {
//            while (left < right) { // find the smallest element, which is the rotated place.
//                int mid = (left + right) / 2;
//                if (nums[mid] > nums[right]) left = mid + 1;
//                else right = mid;
//            }
//
//            // change the loop range.
//            if (target == nums[nums.length-1]) return true;
//            else if (target > nums[nums.length-1]) {
//                right = left - 1;
//                left = 0;
//            }
//            else right = nums.length-1;
//        }
//
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] == target) return true;
//            else if (nums[mid] < target) left++;
//            else right--;
//        }
//
//        return false;
//    }
}
