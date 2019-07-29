package items;

public class SortColors_75 {
    /**
     * 0: red   1: white   2: blue
     *
     * We use 3 pointers(redRight, blueLeft and current index) to divide the array into three parts.
     *
     * 1. if nums[index] == 0, we exchange the value of current index and redRight, and redRight++, index++;
     * 2. if nums[index] == 2, we exchange the value of current index and blueLeft, and blueLeft--;
     *
     * Note: when we nums[index] == 2, we exchange the value of current index and blueLeft--, but we dont do index--,
     *       because the value of blueLeft is not check(such as nums[index] == 2, and nums[blueLeft] == 0), when we
     *       exchanged the value, the nums[index] == 0, and it need to recheck. However, if nums[index] == 0, we can
     *       exchange directly, because left values have checked, and dont need to recheck.
     * @param nums input array.
     */
    public static void sortColors(int[] nums) {
        int redRight = 0, index = 0, blueLeft = nums.length-1;

        while (index <= blueLeft) {
            int tmp;
            if (nums[index] == 0) {
                tmp = nums[redRight];
                nums[redRight++] = nums[index];
                nums[index++] = tmp;
            }
            else if (nums[index] == 2) {
                tmp = nums[blueLeft];
                nums[blueLeft--] = nums[index];
                nums[index] = tmp;
            }
            else index++;
        }
    }
}
