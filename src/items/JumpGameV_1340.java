package items;

/**
 * @author hechuan
 */
public class JumpGameV_1340 {

    /**
     * Simple solution with backtracking and cache.
     *
     * @param arr input array
     * @param d limit length
     * @return the maximum steps we can jump
     */
    public int maxJumps1(int[] arr, int d) {
        // cache[i] means the maximum steps we can jump from index i.
        int[] cache = new int[arr.length];

        // fill the cache array and find the maximum steps.
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, backTracking(arr, d, i, cache));
        }

        return res;
    }

    private int backTracking(int[] arr, int d, int start, int[] cache) {
        if (cache[start] != 0) { return cache[start]; }

        int tmp, res = 1;
        int low = Math.max(0, start - d);
        int high = Math.min(arr.length - 1, start + d);
        // get the real index that we can start from.
        for (int i = start-1; i >= low; i--) {
            if (arr[i] >= arr[start]) {
                low = i+1;
                break;
            }
        }

        // get the real index that we can end at.
        for (int i = start+1; i <= high; i++) {
            if (arr[i] >= arr[start]) {
                high = i-1;
                break;
            }
        }

        // do backtracking.
        for (int i = low; i <= high; i++) {
            if (i != start) {
                tmp = 1;
                tmp += backTracking(arr, d, i, cache);
                res = Math.max(res, tmp);
            }
        }

        return cache[start] = res;
    }

    public int maxJumps2(int[] arr, int d) {
        int[] dp = new int[arr.length];
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, dp(arr, d, i, dp));
        }

        return res;
    }

    /**
     * Simple solution with dp, same as backtracking solution with cache.
     *
     * @param arr input array
     * @param d limit length
     * @return the maximum steps we can jump
     */
    private int dp(int[] arr, int d, int start, int[] dp) {
        if (dp[start] != 0) { return dp[start]; }

        int res = 1;
        int high = Math.min(arr.length-1, start+d);
        int low = Math.max(0, start-d);
        for (int i = start+1; i <= high && arr[i] < arr[start]; i++) {
            res = Math.max(res, 1+dp(arr, d, i, dp));
        }

        for (int i = start-1; i >= low && arr[i] < arr[start]; i--) {
            res = Math.max(res, 1+dp(arr, d, i, dp));
        }

        return dp[start] = res;
    }
}
