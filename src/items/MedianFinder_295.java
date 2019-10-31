package items;

import java.util.PriorityQueue;

/**
 * Use a small top heap and a big top heap to store a half of numbers respectively.
 * The big top heap stores the first half smaller elements, and the small top heap stores the second half bigger ones.
 * If total number is even, the two heaps stores n/2 elements respectively.
 * If total number is old, the big top heap stores n/2 + 1 elements.
 *
 *
 * @author hechuan
 */
public class MedianFinder_295 {

    private PriorityQueue<Integer> smallTopHeap;
    private PriorityQueue<Integer> bigTopHeap;
    private boolean even;

    /** initialize your data structure here. */
    public MedianFinder_295() {
        smallTopHeap = new PriorityQueue<>();
        bigTopHeap = new PriorityQueue<>((w1, w2) -> w2 - w1);
        even = true;
    }

    public void addNum(int num) {
        if (even) {
            smallTopHeap.offer(num);
            bigTopHeap.offer(smallTopHeap.poll());
        }
        else {
            bigTopHeap.offer(num);
            smallTopHeap.offer(bigTopHeap.poll());
        }

        even = !even;
    }

    public double findMedian() {
        return bigTopHeap.isEmpty() ? 0 : (even ? (bigTopHeap.peek() + smallTopHeap.peek())/2.0 : bigTopHeap.peek());
    }
}
