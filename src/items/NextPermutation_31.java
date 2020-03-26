package items;

/**
 * @author hechuan
 */
public class NextPermutation_31 {

    public void nextPermutation(int[] nums) {
        int i = nums.length-2;

        // 找到以第一个nums[i] < nums[i+1]的下标
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if (i >= 0) {
            // 在i的右侧，找到最小的比num[i]大的数的坐标
            int j = nums.length - 1;
            for (; j > i; j--) {
                if (nums[j] > nums[i]) { break; }
            }
            // 交换两者的位置
            swap(nums, i, j);
        }
        // 对i右侧的数字按递增排序，它们之前是按递减的顺序排序的
        reverse(nums, i+1);
    }

    private void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1, tmp;
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
