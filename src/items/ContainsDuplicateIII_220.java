package items;

import java.util.HashMap;
import java.util.Map;

/**
 * The first approach is bucket means, the second one is line searching.
 */
public class ContainsDuplicateIII_220 {

    /**
     * Bucket means to solve the problem with O(n) time complexity.
     *  The buckets are like below:
     *      -1th: [-t-1, -1],
     *      0th: [0, t],
     *      1st: [t+1, 2t+1]
     *      ...
     *
     * The width of the bucket is t+1, and the index of nums[i]: index = nums[i]/width.
     *
     * We use a map to manage the buckets. Note that each bucket can contain one element at most, if there are more than
     * one numbers in a bucket, they are duplicate because they are in the range of t.
     *
     * Moreover, duplicate numbers may lie in the adjacent buckets, i.e. bucket i and i+1 or i-1.
     * Finally, if the index of the array is large than k, we need to remove the corresponding bucket.
     *
     * Time complexity: O(n). For each element of the array, we need do three operations in the hash map: search, insert
     * and remove. All of them will be finished with constant complexity O(1).
     *
     * Space complexity: O(min(n,k))
     *
     * @param nums input array
     * @param k the range of the array index
     * @param t the range of the numbers diff
     * @return whether there are duplicate numbers
     */
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {return false;}

        Map<Long, Long> buckets = new HashMap<>(nums.length);
        // as the area [0, t] contains t+1 numbers.
        long width = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            long index = getIndex(nums[i], width);
            // check if bucket m is empty, each bucket may contain at most one element
            if (buckets.containsKey(index)) {return true;}
            // as the width = t+1, so the diff can not be equal to width.
            // check the adjacent buckets.
            if (buckets.containsKey(index-1) && nums[i] - buckets.get(index-1) < width) {return true;}
            if (buckets.containsKey(index+1) && buckets.get(index+1) - nums[i] < width) {return true;}
            buckets.put(index, (long) nums[i]);
            // if i is equal to k, the next one will be large than k and do invalid actions.
            if (i >= k) {buckets.remove(getIndex(nums[i-k], width));}
        }

        return false;
    }

    /**
     * The buckets are like:
     *     -1th: [-t-1, -1],
     *     0th: [0, t],
     *     1st: [t+1, 2t+1]...
     * To involve the negative numbers, we add some operations:
     * 1. num > 0, index = num / width;
     * 2. num = 0, we need to make it into the 0th bucket, so we first add 1 (num+1), and then subtract 1.
     * 3. num < 0, we need to make it into the -1th bucket.
     *
     * @param num the number to arrange index
     * @param width the width of the bucket
     * @return the index of the number
     */
    private long getIndex(long num, long width) {
        return num < 0 ? (num + 1) / width - 1 : num / width;
    }

    /**
     *
     * Time complexity: O(n*min(k,n)).
     * Space complexity: O(1)
     *
     * @param nums input array
     * @param k the range of the array index
     * @param t the range of the numbers diff
     * @return whether there are duplicate numbers
     */
    public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        //int left = 0, right = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length && j <= i+k; j++) {
                long temi = (long) nums[i];
                long temj = (long) nums[j];
                long diff = Math.abs(temj-temi);
                if (diff > Integer.MAX_VALUE) {return false;}
                if (diff <= t) {return true;}
            }
        }
        return false;
    }
}
