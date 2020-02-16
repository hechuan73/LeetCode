package items;

import java.util.*;

/**
 * @author hechuan
 */
public class MaximumNumberOfEventsThatCanBeAttended_1353 {

    public int maxEvents1(int[][] events) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int i = 0, res = 0, n = events.length;
        for (int d = 0; d <= 100000; d++) {
            while (i < n && events[i][0] == d) {
                heap.offer(events[i++][1]);
            }

            while (heap.size() > 0 && heap.peek() < d) {
                heap.poll();
            }

            if (heap.size() > 0) {
                heap.poll();
                res++;
            }
        }

        return res;
    }

    public int maxEvents2(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        Set<Integer> set = new HashSet<>();

        for (int[] event : events) {
            if (event[0] == event[1]) { set.add(event[0]); }
            else {
                for (int i = event[0]; i <= event[1]; i++) {
                    if (set.add(i)) { break; }
                }
            }
        }

        return set.size();
    }
}
