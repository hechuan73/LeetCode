package items;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicateII_219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {set.remove(nums[i-k-1]);}
            if (!set.add(nums[i])) {return true;}
        }

        return false;
    }
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        HashMap<Integer, Integer> numberToIndex = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (numberToIndex.containsKey(nums[i]) && (i-numberToIndex.get(nums[i]) <= k)) { return true; }
            else {numberToIndex.put(nums[i], i);}
        }

        return false;
    }
}
