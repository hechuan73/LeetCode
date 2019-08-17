package items;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays_349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        int[] result = new int[Math.min(nums1.length, nums2.length)];

        Set<Integer> set1 = new HashSet<>(nums1.length);
        for (int i : nums1) { set1.add(i); }

        Set<Integer> set2 = new HashSet<>(nums2.length);
        for (int i : nums2) { set2.add(i); }

        int index = 0;
        for (Integer integer : set1) {
            if (set2.contains(integer)) {result[index++] = integer; }
        }

        // return the valid elements, the elements behind the index are 0 which are invalid.
        return Arrays.copyOf(result, index);
    }
}
