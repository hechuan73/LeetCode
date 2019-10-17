package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class FindAllDuplicatesInAnArray_442 {

    /**
     * 抽屉原理：也称作鸽巢原理。n+1只鸽子放进n只笼子，则必有一直笼子有两只鸽子。
     *
     * Approach 1: 利用抽屉原理交换的通用解法
     *
     * 这里，我们注意到：1 <= a[i] <= n，数组元素限定在素组长度内，我们可以通过一次遍历使得：
     *     数值 1 就放在索引位置 0 处；
     *     数值 2 就放在索引位置 1 处；
     *     数值 3 就放在索引位置 2 处；
     *     ...
     * 最后再遍历一次数组，发现a[i]-1 != i的，即无处安放的元素，则为重复元素。
     *
     * 其中，我们需要进行元素间的交换，来完成元素安放。由于不能使用额外空间，这里可以使用"基于异或运算交换两个变量"。
     * "异或运算"是不进位的二进制加法，有如下性质：
     *     如果 a ^ b = c, 那么 a ^ c = b, b ^ c = a.
     * 由此可得：
     * 异或运算交换a, b的值可由如下三步：
     *     1. a = a ^ b;
     *     2. b = a ^ b;
     *     3. a = a ^ b;
     *
     * 事实上，通过加减法，三步也可交换两者的值，不过可能会有溢出风险：
     *     1. a = a + b;
     *     2. b = a - b;
     *     3. a = a - b;
     *
     * Note: 在异或交换方法中， 如果a, b两个下标相等，则最终交换的值为0，因为只有一个元素，a ^ a = 0.
     *
     * @param nums input array
     * @return the duplicated numbers
     */
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) { res.add(nums[i]); }
        }

        return res;
    }

    private void swap(int[] nums, int a, int b) {
        if (a == b) { return; }

        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

    /**
     * Approach 2: 利用抽屉原理标记的通用解法
     *
     * 这里，与上一种方法不同，我们只进行标记，标记某个元素应该存放的位置，其下标为nums[nums[i]-1]。之所以将小表标记为相反数，是因为便于我们
     * 计算，来获取到对应的元素值。也可以修改为其他，但是在计算index也需要对应变化。
     *
     * @param nums input array
     * @return the duplicated numbers
     */
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0) { res.add(Math.abs(nums[i])); }
            nums[index] = -nums[index];
        }

        return res;
    }


}
