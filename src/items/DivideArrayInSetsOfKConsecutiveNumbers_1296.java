package items;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author hechuan
 */
public class DivideArrayInSetsOfKConsecutiveNumbers_1296 {

    /**
     * Simple method with hash map.
     *
     * @param nums input array
     * @param k input k
     * @return whether the array is possible to divide
     */
    public boolean isPossibleDivide1(int[] nums, int k) {
        if (nums.length % k != 0) { return false; }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) { map.put(num, map.getOrDefault(num, 0) + 1); }

        Arrays.sort(nums);
        int key;
        for (int i = 0; i < nums.length-k; i++) {
            if (map.get(nums[i]) > 0) {
                for (int j = 0; j < k; j++) {
                    key = nums[i]+j;
                    if (!map.containsKey(key) || map.get(key) == 0) { return false; }
                    else { map.put(key, map.get(key)-1); }
                }
            }
        }

        return true;
    }

    /**
     * Optimised method with priority queue/tree map to check batch.
     *
     * @param nums input array
     * @param k input k
     * @return whether the array is possible to divide
     */
    public boolean isPossibleDivide2(int[] nums, int k) {
        if(nums.length % k != 0) { return false; }
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) { map.put(n, map.getOrDefault(n, 0) + 1); }

        PriorityQueue<Integer> pq = new PriorityQueue<>(map.keySet());
        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(map.get(cur) == 0) { continue; }
            int times = map.get(cur);
            for(int i = 0; i < k; i++){
                if(!map.containsKey(cur + i) || map.get(cur + i) < times) { return false; }
                map.put(cur + i, map.get(cur + i) - times);
            }
        }
        return true;
    }
}
