package items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hechuan
 */
public class TopKFrequentElements_347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCounter = new HashMap<>(nums.length);

        for (int num : nums) {
            numCounter.put(num, numCounter.getOrDefault(num, 0)+1);
        }

        // use bucket sort
        List<Integer>[] buckets = new List[nums.length];
        numCounter.forEach((key, value) -> {
            if (null == buckets[value]) { buckets[value] = new ArrayList<Integer>();}
            buckets[value].add(key);
        });

        List<Integer> res = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && res.size() < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    res.add(num);
                    if (res.size() == k) { return res;}
                }
            }
        }

        return res;
    }
}
