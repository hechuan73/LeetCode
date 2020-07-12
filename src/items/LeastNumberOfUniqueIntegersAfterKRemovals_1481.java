package items;

import java.util.*;

/**
 * @author hechuan
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals_1481 {

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i : arr) {
            counter.put(i, counter.getOrDefault(i, 0)+1);
        }

        TreeMap<Integer, List<Integer>> timeCounter = new TreeMap<>();
        int value;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            value = entry.getValue();
            timeCounter.computeIfAbsent(value, k1 -> new ArrayList<>());
            timeCounter.get(value).add(entry.getKey());
        }

        int res = counter.size();
        Map.Entry<Integer, List<Integer>> entry;
        while (k > 0 && !timeCounter.isEmpty()) {
            entry = timeCounter.firstEntry();
            int remain = k / entry.getKey();
            if (remain == 0) {
                break;
            }
            else if (remain <= entry.getValue().size()) {
                res -= remain;
                break;
            }
            else {
                res -= entry.getValue().size();
                k -= entry.getValue().size()*entry.getKey();
                timeCounter.remove(entry.getKey());
            }
        }

        return res;
    }
}
