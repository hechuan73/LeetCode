package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class ReduceArraySizeToTheHalf_5329 {

    /**
     * Simple solution will bucket counter.
     *
     * @param arr input array
     * @return the minimum set size
     */
    public int minSetSize(int[] arr) {
        int[] counter = new int[100001];
        for (int i : arr) { counter[i]++; }
        List<Integer>[] times = new List[100001];
        int half = (arr.length % 2 == 0) ? arr.length/2 : arr.length/2+1;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] >= half) { return 1; }
            if (times[counter[i]] == null) { times[counter[i]] = new ArrayList<>(); }
            times[counter[i]].add(i);
        }

        int len = half, res = 0;
        for (int i = len; i > 0; i--) {
            if (times[i] != null) {
                for (int size = times[i].size(); size > 0; size--) {
                    half -= i;
                    res += 1;
                    if (half <= 0) { return res; }
                }
            }
        }

        return res;
    }
}
