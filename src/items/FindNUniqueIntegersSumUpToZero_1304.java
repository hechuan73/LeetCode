package items;

/**
 * @author hechuan
 */
public class FindNUniqueIntegersSumUpToZero_1304 {

    public int[] sumZero(int n) {
        int[] res = new int[n];
        int mid = n / 2;
        int index = 0;
        for (int i = 1; i < mid+1; i++) {
            res[index++] = i;
            res[index++] = -i;
        }

        return res;
    }
}
