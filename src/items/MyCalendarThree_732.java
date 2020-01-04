package items;

import java.util.TreeMap;

/**
 * @author hechuan
 */
public class MyCalendarThree_732 {

    private TreeMap<Integer, Integer> map;

    public MyCalendarThree_732() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        // try to add the event: start is +1, and end is -1. It is for calculation.
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int max = 0, count = 0;
        for (Integer value : map.values()) {
            count += value;
            max = Math.max(max, count);
        }
        return max;
    }
}