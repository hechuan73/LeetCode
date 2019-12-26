package items;

import java.util.Arrays;

/**
 * @author hechuan
 */
public class ArrayPartitionI_561 {

    /**
     *
     * 为了理解这种方法，让我们从不同的角度来看待问题。我们需要形成数组元​​素的配对，使得这种配对中最小的总和最大。因此，我们可以查看选择配对中最小
     * 值的操作，比如(a, b)可能会产生的最大损失a−b(如果a>b)。
     *
     * 如果这类配对产生的总损失最小化，那么总金额现在将达到最大值。只有当为配对选择的数字比数组的其他元素更接近彼此时，才有可能将每个配对中的损失
     * 最小化。考虑到这一点，我们可以对给定数组的元素进行排序，并直接按排序顺序形成元素的配对。这将导致元素的配对，它们之间的差异最小，从而导致所
     * 需总和的最大化。
     *
     * @param nums input array
     * @return the minimum sum of array pair
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }

        return res;
    }

}
