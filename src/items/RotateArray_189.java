package items;

public class RotateArray_189 {

    /**
     * Approach 1: Cycle replacement
     *     For nums: [1, 2, 3, 4, 5, 6], k: 2
     *
     *     |--------------------
     *     v                   |
     *     1    2    3    4    5   6
     *     |        | |        ^
     *     |________| |________|
     *
     *     1 -> 3; 3 -> 5; 5 -> 1
     *
     * Time Complexity: O(n).
     * Space Complexity: O(1).
     *
     * @param nums input array
     * @param k times of rotation
     */
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        // count the rotated numbers
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            // for one cycle replacement
            do {
                int next = (current + k) % nums.length;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                current = next;
                count++;
            } while (current != start);
        }
    }

    /**
     * Approach 2: Reverse
     * For example: For nums: [1, 2, 3, 4, 5, 6, 7], k: 3
     *     Original List                   : 1 2 3 4 5 6 7
     *     After reversing all numbers     : 7 6 5 4 3 2 1
     *     After reversing first k numbers : 5 6 7 4 3 2 1
     *     After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
     *
     * Time Complexity: O(n).
     * Space Complexity: O(1).
     *
     * @param nums input array
     * @param k times of rotation
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        // reverse all numbers.
        reverse(nums, 0, nums.length-1);
        // reverse the first k numbers.
        reverse(nums, 0, k-1);
        // reverse the rest numbers.
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}
