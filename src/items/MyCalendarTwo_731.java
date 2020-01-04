package items;

import java.util.TreeMap;

/**
 * @author hechuan
 */
public class MyCalendarTwo_731 {

    private TreeMap<Integer, Integer> map;

    public MyCalendarTwo_731() {
        map = new TreeMap<>();
    }

    /**
     * The map stores the active events of the start. Key is the start day, and the value is active events amount.
     *
     * @param start beginning of the event
     * @param end ending of the event
     * @return whether it can book the event without triple booking
     */
    public boolean book(int start, int end) {
        // try to add the event: start is +1, and end is -1. It is for calculation.
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        // count the active event amount.
        int count = 0;
        for (Integer value : map.values()) {
            count += value;
            // if the active event is equal to or more than 3.
            if (count >= 3) {
                // reset the calendar.
                map.put(start, map.getOrDefault(start, 0) - 1);
                map.put(end, map.getOrDefault(end, 0) + 1);

                // remove this part, it can passes. but this will only costs more spaces.
                if (map.get(start) == 0) { map.remove(start); }
                if (map.get(end) == 0) { map.remove(end); }

                return false;
            }
        }

        return true;
    }

}
