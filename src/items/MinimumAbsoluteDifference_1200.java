package items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hechuan
 */
public class MinimumAbsoluteDifference_1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i]-arr[i-1];
            if (diff <= min) {
                if (diff < min) {
                    res = new ArrayList<>();
                    min = diff;
                }
                res.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }

        return res;
    }
}
