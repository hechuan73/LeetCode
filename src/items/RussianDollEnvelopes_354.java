package items;

import java.util.Arrays;

/**
 * @author hechuan
 */
public class RussianDollEnvelopes_354 {

    /**
     * 这是一个二维DP问题，所以我们需要先将一维进行排序，降低一维。比如按照第一维元素宽度进行升序排序，当第一维元素相同时，将第二维高度进行降序
     * 排序，然后在第二维高度上求LIS（最长上升子串）问题。之所以第二维要降序是因为，如果升序排序，当第一维相同时，第二维会被当做升序序列。比如：
     * [3, 3], [3, 4]，会认为"3, 4"是一个上升序列，但由于第一维相同，所以是不符合要求的。所以第二维用降序来规避这个问题。
     *
     *
     * @param envelopes input 2-D array
     * @return the maximum put envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        int[] dp = new int[envelopes.length];
        int end = 0, index;
        for (int[] envelope : envelopes) {
            // 二分法+贪心 求最长上升子串
            index = Arrays.binarySearch(dp, 0, end, envelope[1]);
            if (index < 0){
                index = -(index+1);
            }
            dp[index] = envelope[1];
            if (index == end){
                end++;
            }
        }

        return end;
    }
}
