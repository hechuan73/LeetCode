package items;

public class SearchInRotatedSortedArray_33 {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        if (nums[left] > nums[right]) {
            while (left < right) { // find the smallest element, which is the rotated place.
                int mid = (left + right) / 2;
                if (nums[mid] > nums[right]) left = mid + 1;
                else right = mid;
            }

            // change the loop range.
            if (target == nums[nums.length-1]) return nums.length-1;
            else if (target > nums[nums.length-1]) {
                right = left - 1;
                left = 0;
            }
            else right = nums.length-1;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left++;
            else right--;
        }

        return -1;
    }
}
