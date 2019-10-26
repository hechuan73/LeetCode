package items;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author hechuan
 */
public class KthLargestElementInAnArray_215 {


    /**
     * Using sort.
     *
     * Time Complexity: O(nlogn)
     * Space Complexity: O(1)
     *
     * @param nums input array
     * @param k the index
     * @return the kth largest number
     */
    public int findKthLargest3(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    /**
     * Using heap sort.
     *
     * Time Complexity: O(nlogK)
     * Space Complexity: O(K)
     *
     * @param nums input array
     * @param k the index
     * @return the kth largest number
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> smallTopHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (smallTopHeap.size() < k) { smallTopHeap.offer(num); }
            else if (smallTopHeap.peek() < num) {
                smallTopHeap.poll();
                smallTopHeap.offer(num);
            }
        }

        return smallTopHeap.peek();
    }


    /**
     * Using quick sort partition.
     *
     * Time Complexity:  best: O(n), worst: O(n2)
     * Space Complexity: O(K)
     *
     * @param nums input array
     * @param k the index
     * @return the kth largest number
     */
    public int findKthLargest1(int[] nums, int k) {
        k = nums.length - k;
        int start = 0, end = nums.length-1;
        while (start < end) {
            int pivot = partition(nums, start, end);
            if (pivot == k) { break; }
            else if (pivot < k) { start = pivot + 1; }
            else { end = pivot - 1; }
        }

        return nums[k];
    }

    private int partition(int[] nums, int start, int end) {
        int index = start;
        for (int i = start; i < end; i++) {
            // the pivot is num[end]
            if (nums[i] < nums[end]) {
                int tmp = nums[index];
                nums[index++] = nums[i];
                nums[i] = tmp;
            }
        }

        int tmp = nums[index];
        nums[index] = nums[end];
        nums[end] = tmp;
        return index;
    }

}
