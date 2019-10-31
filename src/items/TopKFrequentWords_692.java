package items;

import java.util.*;

/**
 * @author hechuan
 */
public class TopKFrequentWords_692 {

    /**
     * Only use map, and sort map's keys.
     *
     * @param words input words array
     * @param k kth
     * @return the top k frequent strings
     */
    public List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> counter = new HashMap<>(words.length);

        for (String word : words) {
            counter.put(word, counter.getOrDefault(word, 0)+1);
        }

        List<String> keys = new ArrayList<>(counter.keySet());
        Collections.sort(keys, (w1, w2) -> counter.get(w1).equals(counter.get(w2))
                ? w1.compareTo(w2) : counter.get(w2) - counter.get(w1));

        return keys.subList(0, k);
    }

    /**
     * Use map and bucket sort.
     *
     * @param words input words array
     * @param k kth
     * @return the top k frequent strings
     */
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> counter = new HashMap<>(words.length);

        for (String word : words) {
            counter.put(word, counter.getOrDefault(word, 0)+1);
        }

        List<String>[] buckets = new List[words.length];
        List<String> keys = new ArrayList<>(counter.keySet());

        Collections.sort(keys);
        for (String key : keys) {
            int index = counter.get(key);
            if (buckets[index] == null) { buckets[index] = new ArrayList<>(); }
            buckets[index].add(key);
        }

        List<String> res = new ArrayList<>();
        List<String> tmp;
        for (int i = buckets.length - 1; i >= 0 && k > 0; i--) {
            if (buckets[i] != null) {
                tmp = buckets[i];
                for (int j = 0; j < tmp.size() && k > 0; j++) {
                    res.add(tmp.get(j));
                    k--;
                }
            }
        }

        return res;
    }

    /**
     * Use map and heap sort.
     *
     * @param words input words array
     * @param k kth
     * @return the top k frequent strings
     */
    public List<String> topKFrequent3(String[] words, int k) {
        Map<String, Integer> counter = new HashMap<>(words.length);

        for (String word : words) {
            counter.put(word, counter.getOrDefault(word, 0)+1);
        }

        PriorityQueue<String> smallTopHeap = new PriorityQueue<>(k, (w1, w2) -> counter.get(w1).equals(counter.get(w2))
                ? w2.compareTo(w1) : counter.get(w1) - counter.get(w2));
        List<String> res = new ArrayList<>(k);
        for (String key : counter.keySet()) {
            smallTopHeap.offer(key);
            if (smallTopHeap.size() > k) { smallTopHeap.poll(); }
        }

        while (!smallTopHeap.isEmpty()) { res.add(smallTopHeap.poll()); }
        Collections.reverse(res);
        return res;
    }


}
