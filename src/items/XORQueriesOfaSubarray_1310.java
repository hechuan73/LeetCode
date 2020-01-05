package items;

/**
 * @author hechuan
 */
public class XORQueriesOfaSubarray_1310 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = arr[queries[i][0]];
            for (int j = queries[i][0]+1; j <= queries[i][1]; j++) {
                res[i] ^= arr[j];
            }
        }

        return res;
    }
}
