package items;

import java.util.TreeMap;

/**
 * @author hechuan
 */
public class MyCalendarI_729 {

    private TreeMap<Integer, Integer> map;

    public MyCalendarI_729() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer low = map.lowerKey(end);

        if (low == null || map.get(low) <= start) {
            map.put(start, end);
            return true;
        }

        return false;
    }
}
