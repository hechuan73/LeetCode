package items;

import java.util.List;

/**
 * @author hechuan
 */
public class Triangle_120 {

    /**
     * Down to up.
     *
     * @param triangle input triangle
     * @return the minimum path sum
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 0) { return 0; }

        List<Integer> curr, next;
        for (int i = size - 2; i >= 0; i--) {
            curr = triangle.get(i);
            next = triangle.get(i+1);

            for (int j = 0; j < curr.size(); j++) {
                curr.set(j, curr.get(j) + Math.min(next.get(j), next.get(j+1)));
            }
        }

        return triangle.get(0).get(0);
    }

    /**
     * Up to down.
     *
     * @param triangle input triangle
     * @return the minimum path sum
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty() || triangle.get(0).isEmpty()) { return 0; }

        List<Integer> levelNums, lastLevelNums;
        int leftUp, rightUp, val;
        for (int i = 1; i < triangle.size(); i++) {
            levelNums = triangle.get(i);
            lastLevelNums = triangle.get(i-1);
            for (int j = 0; j < levelNums.size(); j++) {
                leftUp = Integer.MAX_VALUE; rightUp = Integer.MAX_VALUE;
                if (j == 0) {
                    rightUp = lastLevelNums.get(j);
                }
                else if (j == levelNums.size()-1) {
                    leftUp = lastLevelNums.get(j-1);
                }
                else {
                    leftUp = lastLevelNums.get(j-1);
                    rightUp = lastLevelNums.get(j);
                }

                val = Math.min(leftUp, rightUp);
                levelNums.set(j, val+levelNums.get(j));
            }
        }
        int res = Integer.MAX_VALUE;
        for (Integer num : triangle.get(triangle.size() - 1)) {
            res = Math.min(res, num);
        }

        return res;
    }

    /**
     * Up to down.
     *
     * 该DP思路不会修改原数组中的元素。一般来说使用二维DP：
     * dp[i][j]表示第i行第j列处的最小路径，其递推公式如下：
     * dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]
     *
     * 由于每次只会使用到dp[i-1][j-1], dp[i-1][j]这两个元素，所以考虑空间压缩，用两个变量保存其值：
     * prev = dp[i-1][j-1];   curr = dp[i-1][j];
     * 而一维dp数组dp[i]表示每一行中到第i个元素的最小的路径和。
     *
     * @param triangle input triangle
     * @return the minimum path sum
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty() || triangle.get(0).isEmpty()) { return 0; }
        if (triangle.size() == 1) { return triangle.get(0).get(0); }

        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        int prev, curr;
        List<Integer> levelNums;
        for (int i = 1; i < triangle.size(); i++) {
            levelNums = triangle.get(i);
            prev = 0;
            for (int j = 0; j < levelNums.size(); j++) {
                curr = dp[j];
                if (j == 0) {
                    dp[j] = curr + levelNums.get(j);
                }
                else if (j == levelNums.size()-1) {
                    dp[j] = prev + levelNums.get(j);
                }
                else {
                    dp[j] = Math.min(curr, prev) + levelNums.get(j);
                }
                prev = curr;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int num : dp) {
            res = Math.min(res, num);
        }

        return res;
    }
}
