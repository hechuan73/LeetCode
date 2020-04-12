package items;

/**
 * @author hechuan
 */
public class QueriesOnaPermutationWithKey_1409 {

    /**
     * Simple solution with two arrays: one for record index to number, one for record number to index.
     *
     * Optimization: Use LinkedList to store numbers and each time move the element to the head. And use the Map to
     * record the pointer of number for each time we search the element.
     *
     * @param queries input query array
     * @param m limit m
     * @return the processed result
     */
    public int[] processQueries(int[] queries, int m) {
        // index -> num
        int[] buckets = new int[m];
        // num -> index
        int[] indexes = new int[m+1];

        for (int i = 1; i <= m; i++) {
            buckets[i-1] = i;
            indexes[i] = i-1;
        }

        int[] res = new int[queries.length];
        int index, tmp;
        for (int i = 0; i < queries.length; i++) {
            res[i] = indexes[queries[i]];
            index = res[i];
            tmp = buckets[index];
            for (int j = index; j > 0; j--) {
                buckets[j] = buckets[j-1];
                indexes[buckets[j]] = j;
            }

            buckets[0] = tmp;
            indexes[buckets[0]] = 0;
        }

        return res;
    }

}
