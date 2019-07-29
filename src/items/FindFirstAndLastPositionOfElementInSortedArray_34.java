package items;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        int left = findBorder(nums, target, true);
        if (left == nums.length || nums[left] != target) return result;

        result[0] = left;
        result[1] = findBorder(nums, target, false)-1;
        return result;
    }

    private static int findBorder(int[] nums, int target, boolean isLeft) {
        int left = 0, right = nums.length;  // 'right = nums.length' is to avoid that the array just has one element.

        while (left < right) {
            int mid = (left + right)/2;

            if (nums[mid] > target || (isLeft && nums[mid] == target))
                right = mid;
            else
                left = mid+1;
        }

        return left;
    }

//    public static int[] searchRange(int[] nums, int target) {
//        int[] result = new int[]{-1, -1};
//        if (nums.length == 0) return result;
//        if (target < nums[0] || target > nums[nums.length-1]) return result;
//        int left = 0, right = nums.length-1;
//
//        boolean isLeft = false, isRight = false;
//
//        while (left <= right) {
//            if (!isLeft) {
//                if (nums[left] == target) {
//                    isLeft = true;
//                    result[0] = left;
//                }
//                else if (nums[left] > target) break;
//                else left++;
//            }
//
//            if (!isRight) {
//                if (nums[right] == target) {
//                    isRight = true;
//                    result[1] = right;
//                }
//                else if (nums[right] < target) break;
//                else right--;
//            }
//
//            if (isLeft && isRight) break;
//        }
//        return result;
}
