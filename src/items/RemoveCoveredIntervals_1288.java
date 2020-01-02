package items;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hechuan
 */
public class RemoveCoveredIntervals_1288 {

    /**
     * Simple method. Compare each interval to all others and check if it is covered by any interval.
     *
     * @param intervals array of intervals
     * @return the intervals which removed the covered ones.
     */
    public int removeCoveredIntervals1(int[][] intervals) {
        int res = intervals.length;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length; j++) {
                if (i != j && canCovered(intervals[i], intervals[j])) {
                    res--;
                    break;
                }
            }
        }

        return res;
    }

    private boolean canCovered(int[] arr1, int[] arr2) {
        return arr2[0] <= arr1[0] && arr2[1] >= arr1[1];
    }

    /**
     * Optimised method with sorting.
     *
     * @param intervals array of intervals
     * @return the intervals which removed the covered ones.
     */
    public int removeCoveredIntervals2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int res = intervals.length, right = -1;

        for (int[] interval : intervals) {
            if (right >= interval[1]) { res--; }
            right = Math.max(right, interval[1]);
        }
        return res;
    }
}
