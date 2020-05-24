package items;

import java.util.Arrays;

/**
 * @author hechuan
 */
public class MaxDotProductOfTwoSubsequences_1458 {

    /**
     * Simple solution with 2D-dp.
     *
     * @param nums1 input array 1
     * @param nums2 input array 2
     * @return the max dot product
     */
    public int maxDotProduct1(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        long[][] dp = new long[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }

        int product;
        long[] tmp;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                product = nums1[i] * nums2[j];
                tmp = new long[]{product, product + dp[i][j], dp[i][j + 1], dp[i + 1][j]};
                Arrays.sort(tmp);
                dp[i + 1][j + 1] = tmp[3];
            }
        }

        return (int) dp[l1][l2];
    }

    /**
     * Optimised solution with 2D-dp.
     *
     * @param nums1 input array 1
     * @param nums2 input array 2
     * @return the max dot product
     */
    public int maxDotProduct2(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        long[][] dp = new long[l1][l2];

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                dp[i][j] = nums1[i] * nums2[j];
                if (i > 0 && j > 0) { dp[i][j] += Math.max(dp[i-1][j-1], 0); }
                if (i > 0) { dp[i][j] = Math.max(dp[i][j], dp[i-1][j]); }
                if (j > 0) { dp[i][j] = Math.max(dp[i][j], dp[i][j-1]); }
            }
        }

        return (int) dp[l1-1][l2-1];
    }
}
