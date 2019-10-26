package items;

import java.util.PriorityQueue;

/**
 * @author hechuan
 */
public class KthLargest_703 {

    private final PriorityQueue<Integer> smallTopHeap;
    private final int k;

    public KthLargest_703(int k, int[] nums) {
        this.k = k;
        smallTopHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (smallTopHeap.size() < k) {
            smallTopHeap.offer(val);
        }
        else if (smallTopHeap.peek() < val) {
            smallTopHeap.poll();
            smallTopHeap.offer(val);
        }

        return smallTopHeap.peek();
    }
}
