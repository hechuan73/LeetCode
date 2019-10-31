package items;

import java.util.PriorityQueue;

public class LastStoneWeight_1046 {

    /**
     * Using two pointers and bucket sort.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param stones input array
     * @return the last stone weight
     */
    public static int lastStoneWeight1(int[] stones) {
        int[] buckets = new int[1001];

        for (int stone : stones) { buckets[stone]++; }

        int slow = buckets.length-1;
        int fast;
        while (slow > 0) {
            if (buckets[slow] % 2 != 0) {
                fast = slow - 1;
                while (fast > 0 && buckets[fast] == 0) { fast--; }
                if (fast == 0) { break; }
                buckets[slow-fast]++;
                buckets[fast]--;
            }
            slow--;
        }

        return slow;
    }

    /**
     * Using heap sort.
     *
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     *
     * @param stones input array
     * @return the last stone weight
     */
    public int lastStoneWeight2(int[] stones) {
        PriorityQueue<Integer> bigTopHeap = new PriorityQueue<>(stones.length, (w1, w2) -> w2-w1);

        for (int stone : stones) { bigTopHeap.offer(stone); }

        int first = 0, second = 0;
        while (!bigTopHeap.isEmpty()) {
            first = bigTopHeap.poll();
            if (bigTopHeap.isEmpty()) { break; }
            second = bigTopHeap.poll();
            bigTopHeap.offer(first-second);
        }

        return first;
    }


}
