package items;


/**
 * Approach 1: The total paths are the sum of right's paths and down's paths. So we can iterate them as method
 *  'uniquePaths1'. However, if the m or n is very big, the process is time-consuming.
 *
 * Approach 2:
 *     1. We need to do n + m - 2 movements to get the path(m - 1 down, n - 1 right), because we start from cell (1, 1).
 *     2. Let's choose (n - 1) movements(number of steps to the right) from (m + n - 2), and rest (m - 1) is (number of
 *     steps down).
 *     3. The count of different paths is all combinations (n - 1) movements from (m + n-2).
 */
public class UniquePaths_62 {

    public static int uniquePaths(int m, int n) {
        int M = m + n -2;
        int N = n - 1;
        double result = 1;
        // Here we calculate the total possible path number
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for (int i = 1; i <= N; i++) {
            result = result*(M - N + i)/i;
        }

        return (int)result;
    }

    public static int uniquePaths1(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;

        int downCount = uniquePaths1(m-1, n);
        int rightCount = uniquePaths1(m, n-1);

        return downCount + rightCount;
    }
}
