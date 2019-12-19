package items;

import java.util.ArrayList;

/**
 * @author hechuan
 */
public class BeautifulArray_932 {

    /**
     * Beautiful array has some properties below:
     * 1. If A is a beautiful array, we add a constant to each element of A, A is also a beautiful array.
     * 2. If A is a beautiful array, we multiply a constant to each element of A, A is also a beautiful array.
     * 3. If A is a beautiful array, we remove some elements in A, A is also a beautiful array.
     * 4. If A is a beautiful array with odd and B is a beautiful array with even, the array A + B is also a beautiful
     *    array, such as {1,5,3,7} + {2,6,4,8} = {1,5,3,7,2,6,4,8}.
     *
     * Suppose array A [1 ~ m] is a beautiful array, we can construct the beautiful array with operations below:
     * 1. We multiply 2 and subtract 1 to each element in A to get a beautiful array with odd numbers, such as {1,3,2,4}
     *    -> {1,5,3,7}.
     * 2. We multiply 2 to each element in A to get a beautiful array with even numbers, such as {1,3,2,4} -> {2,6,4,8}.
     * 3. We concat these two beautiful array to construct a new big beautiful array, such as {1,3,2,4} + {2,6,4,8} ->
     *    {1,5,3,7,2,6,4,8}.
     * 4. Remove the elements which are bigger than N from the new beautiful array to get the result for the problem.
     *
     * @param N input range N
     * @return one of the available beautiful arrays.
     */
    public static int[] beautifulArray(int N) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        ArrayList<Integer> tmp;
        while (res.size() < N) {
            tmp = new ArrayList<>();
            for (int i : res) { if (i * 2 - 1 <= N) { tmp.add(i * 2 - 1); } }
            for (int i : res) { if (i * 2 <= N) { tmp.add(i * 2); } }
            res = tmp;
        }

        int[] ans = new int[N];
        int index = 0;
        for (Integer num : res) {
            ans[index++] = num;
        }

        return ans;
    }
}
