package items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author hechuan
 */
public class MergeIntervals_56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] last = intervals[0];
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > last[1]) {
                ans.add(last);
                last = intervals[i];
            }
            else {
                last[1] = Math.max(last[1], intervals[i][1]);
            }
        }

        ans.add(last);
        return ans.toArray(new int[ans.size()][2]);
    }
}
