package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class InsertInterval_57 {

    /**
     * Simple solution with comparing one by one.
     *
     * @param intervals   intervals array
     * @param newInterval new interval to insert
     * @return the inserted intervals
     */
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> res = new ArrayList<>();
        for (; i < intervals.length; i++) {
            if (newInterval[0] < intervals[i][0]) {
                if (newInterval[1] < intervals[i][0]) {
                    i--;
                    break;
                }
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            } else if (newInterval[0] == intervals[i][0]) {
                if (newInterval[1] <= intervals[i][1]) {
                    newInterval[1] = intervals[i][1];
                    break;
                }
            } else {
                if (newInterval[0] <= intervals[i][1]) {
                    newInterval[0] = intervals[i][0];
                    if (newInterval[1] <= intervals[i][1]) {
                        newInterval[1] = intervals[i][1];
                        break;
                    }
                } else {
                    res.add(intervals[i]);
                }
            }
        }

        res.add(newInterval);
        for (int j = i + 1; j < intervals.length; j++) {
            res.add(intervals[j]);
        }

        return res.toArray(new int[res.size()][2]);
    }

    /**
     * Clear simple solution with comparing one by one.
     *
     * @param intervals   intervals array
     * @param newInterval new interval to insert
     * @return the inserted intervals
     */
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i++][1], newInterval[1]);
        }

        res.add(newInterval);

        while (i < intervals.length) {
            res.add(intervals[i++]);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
