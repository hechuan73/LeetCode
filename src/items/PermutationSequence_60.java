package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class PermutationSequence_60 {

    /**
     * The basic method is backtracking and find the kth permutation.
     *
     * The optimised method is use mathematical method. See the example.
     * n = 4, k = 9; -> [1, 2, 3, 4]
     * Suppose the fist number is chosen, so the number of permutations is (n-1)!
     * 1. 9 / (4-1)! = 1 ... 3  -> since the remainder is 3 not 0, so we can find the first number is (1+1)th number 2.
     * When we choose 2 as the first number, the remained array is [1, 3, 4]
     * 2. 3 / (3-1)! = 1 ... 1  -> since the remainder is 1 not 0, so we can find the second number is (1+1)th 3.
     * When we choose 3 as the second number, the remained array is [1, 4]
     * 3. 1 / (2-1)! = 1 ... 0  -> since the remainder is 0, so we can find the third number is 1st number 1.
     * When we choose 1 as the third number, the remained array is [4]
     * 4. 0 / (1-1)! = 1 ... 0 -> since the remainder is 0, so we can find the third number is 1st number 4.
     * When we choose 1 as the fourth number, the remained array is [], no elements, so finish the process.
     *
     *
     * @param n the number range [1, n]
     * @param k the kth number
     * @return the kth permutation
     */
    public static String getPermutation(int n, int k) {
        int[] factorial = new int[n+1];
        List<Integer> nums = new ArrayList<>(n);
        factorial[0] = 1;
        // cache the factorial and each number.
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i-1]*i;
            nums.add(i);
        }

        StringBuilder res = new StringBuilder();
        int index;

        // k means kth number, which start from 1 to k, while we cache number from index 0 to index n-1, so we need to
        // subtract 1 to align the index.
        k--;
        for (int i = 1; i <= n; i++) {
            index = k / factorial[n-i];
            res.append(nums.get(index));
            nums.remove(index);
            k -= index*factorial[n-i];
        }

        return res.toString();
    }
}
