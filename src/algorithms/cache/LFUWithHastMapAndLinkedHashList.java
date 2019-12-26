package algorithms.cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Least Frequently Used Algorithm implemented by Hash map and linked hash list. (最近最少使用算法)
 *
 * @author hechuan
 */
public class LFUWithHastMapAndLinkedHashList {
    private final Map<Integer, Integer> values;
    private final Map<Integer, Integer> keyCounts;
    private final Map<Integer, LinkedHashSet<Integer>> countList;
    int capacity;
    int minCount;

    public LFUWithHastMapAndLinkedHashList(int capacity) {
        this.capacity = capacity;
        values = new HashMap<>();
        keyCounts = new HashMap<>();
        countList = new HashMap<>();
        // init for putting new elements.
        countList.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!values.containsKey(key)) { return -1; }

        int count = keyCounts.get(key);
        keyCounts.put(key, count+1);
        countList.get(count).remove(key);
        if (minCount == count && countList.get(count).size() == 0) { minCount++; }

        countList.computeIfAbsent(count + 1, k -> new LinkedHashSet<>());
        countList.get(count+1).add(key);

        return values.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) { return; }

        if (values.containsKey(key)) {
            values.put(key, value);
            get(key);
            return;
        }

        if (values.size() >= capacity) {
            int evict = countList.get(minCount).iterator().next();
            values.remove(evict);
            keyCounts.remove(evict);
            countList.get(minCount).remove(evict);
        }

        values.put(key, value);
        keyCounts.put(key, 1);
        countList.get(1).add(key);
        minCount = 1;
    }
}
