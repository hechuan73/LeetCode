package items;

/**
 * @author hechuan
 */
public class FindLuckyIntegerInAnArray_1394 {

    public int findLucky(int[] arr) {
        int[] counter = new int[501];
        for (int i : arr) {
            counter[i]++;
        }

        int res = -1;
        for (int i = 1; i < counter.length; i++) {
            if (counter[i] == i) {
                res = Math.max(res, i);
            }
        }

        return res;
    }
}
