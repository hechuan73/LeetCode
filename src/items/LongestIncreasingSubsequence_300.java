package items;

/**
 * @author hechuan
 */
public class LongestIncreasingSubsequence_300 {

    /**
     * Simple dynamic programming with iteration in two nested loop.
     *
     * Time complexity: O(n2)
     * Space complexity: O(n)
     *
     * @param nums input array
     * @return the length of longest increasing subsequence
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) { return 0; }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1, loopMax;
        for (int i = 1; i < nums.length; i++) {
            loopMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    loopMax = Math.max(loopMax, dp[j]);
                }
            }

            dp[i] = loopMax + 1;
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    /**
     * Improved dynamic programming with iteration and binary search.
     * 结合二分的思想的思想，来进行优化：
     * 1. 动态规划中，通过线性遍历来计算 dp 的复杂度无法降低；
     * 2. 每轮计算中，需要通过线性遍历 [0,k) 区间元素来得到 dp[k]。我们考虑：是否可以通过重新设计状态定义，使整个 dp为一个排序列表；这样在计
     *    算每个 dp[k]时，就可以通过二分法遍历 [0,k)区间元素，将此部分复杂度由 O(N)降至 O(logN)。
     *
     * 总的想法：dp数组是一个有序的数组，存储递增的列表，当遇到后一个值比前一个值大时，我们添加到dp数组末尾，当遇到后一个值比前一个值小时，我们
     * 在前面的dp数组中找到其应该插入的位置（其实是替换之前的某个值），即新开始一个递增序列，这样其实dp数组保存了两个递增序列的部分元素，当第二
     * 个递增序列的长度超过第一个时，第一个递增序列会完全被第二个覆盖。最后dp数组的长度，即为最长的递增序列。
     *
     * 举个例子，对于序列：[10,9,2,5,3,7,101,18,6]
     * 1. dp[10]
     * 2. dp[9]
     * 3. dp[2]
     * 4. dp[2, 5]
     * 5. dp[2, 3] // 开始新序列[2, 3]
     * 6. dp[2, 3, 7]
     * 7. dp[2, 3, 7, 101]
     * 8. dp[2, 3, 7, 18] // 开始新序列[2,3,7,18]
     * 9. dp[2, 3, 6, 18] // 开始新序列
     *
     * 所以最长的序列为[2,3,7,101]和[2,3,7,18]，不过它们的长度都为4。
     *
     *
     * Time complexity: O(nlogn)
     * Space complexity: O(n)
     *
     * @param nums input array
     * @return the length of longest increasing subsequence
     */
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        int start, mid, end;
        for (int num : nums) {
            start = 0;
            end = res;
            while (start < end) {
                mid = start + ((end-start)>>1);
                if (dp[mid] < num) { start = mid + 1; }
                else { end = mid; }
            }
            dp[start] = num;
            if (res == end) { res++; }
        }

        return res;
    }
}
