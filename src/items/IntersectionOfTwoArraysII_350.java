package items;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hechuan
 */
public class IntersectionOfTwoArraysII_350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counter = new HashMap<>(nums1.length);
        int[] result = new int[Math.min(nums1.length, nums2.length)];

        for (int i : nums1) {
            counter.put(i, counter.getOrDefault(i, 0)+1);
        }

        int index = 0;
        for (int i : nums2) {
            if (counter.containsKey(i) && counter.get(i)>0) {
                result[index++] = i;
                counter.put(i, counter.get(i)-1);
            }
        }

        return Arrays.copyOf(result, index);
    }
}
