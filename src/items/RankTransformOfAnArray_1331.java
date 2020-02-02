package items;

import java.util.*;

/**
 * @author hechuan
 */
public class RankTransformOfAnArray_1331 {

    /**
     * Simple solution with HashMap.
     *
     * @param arr input array
     * @return the transformed rank array
     */
    public int[] arrayRankTransform1(int[] arr) {
        Map<Integer, List<Integer>> valueToIndexes = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            valueToIndexes.computeIfAbsent(arr[i], k -> new ArrayList<>());
            valueToIndexes.get(arr[i]).add(i);
        }

        int[] res = new int[arr.length];
        Arrays.sort(arr);
        List<Integer> indexes;
        int rank = 1;
        for (int i = 0; i < arr.length;) {
            indexes = valueToIndexes.get(arr[i]);
            for (Integer index : indexes) { res[index] = rank; }
            i += indexes.size();
            rank++;
        }

        return res;
    }

    /**
     * Optimised solution with TreeMap.
     *
     * @param arr input array
     * @return the transformed rank array
     */
    public int[] arrayRankTransform2(int[] arr) {
        Map<Integer, List<Integer>> valueToIndexes = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            valueToIndexes.computeIfAbsent(arr[i], k -> new ArrayList<>());
            valueToIndexes.get(arr[i]).add(i);
        }

        int rank = 1;
        for (Map.Entry<Integer, List<Integer>> entry : valueToIndexes.entrySet()) {
            for (Integer index : entry.getValue()) { arr[index] = rank; }
            rank++;
        }

        return arr;
    }

}
