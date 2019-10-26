package items;

/**
 * @author hechuan
 */
public class MaxConsecutiveOnesIII_1004 {

    /**
     * Approach: General Approach
     *
     * @param A input array
     * @param K repeating times
     * @return the length of longest repeating subarray.
     */
    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0, res = 0;
        int[] counter = new int[2];
        int maxLen = 0;

        while (right < A.length) {
            counter[A[right]]++;
            maxLen = Math.max(maxLen, counter[1]);
            while ((right-left+1)-maxLen > K) {
                counter[A[left++]]--;
            }

            res = Math.max(res, right-left+1);
            right++;
        }

        return res;
    }

    /**
     * If we want to get the longest repeating subsequence of the special number, we can optimise the slide window as
     * below. The longest length is the window length, and don't need to save the maxLen of the number/character in the
     * window.
     *
     * @param A input array
     * @param K repeating times
     * @return the length of longest repeating subarray.
     */
    public int longestOnes0(int[] A, int K) {
        int left = 0, right = 0;

        while (right < A.length) {
            if (A[right++] != 1) { K--; }
            if (K < 0 && A[left++] == 0) { K++; }
        }

        // when the while loop ends, right == A.length, but A[A.length] doesn't exist, so the length of window is right-left.
        return right-left;
    }
}
