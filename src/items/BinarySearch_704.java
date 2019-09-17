package items;

public class BinarySearch_704 {

    public int search(int[] nums, int target) {
        int low = 1, high = nums.length-1;

        while (low <= high) {
            int mid = low + ((high-low)>>1);
            if (nums[mid] == target) { return mid; }
            else if (nums[mid] < target) { low = mid + 1; }
            else { high = mid - 1; }
        }

        return -1;
    }
}
