package items;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hechuan
 */
public class MergeKSortedLists_23 {

    /**
     * Using heap sort.
     *
     * Time Complexity: O(Nlogk)
     * Space Complexity: O(k)
     *
     * @param lists input list array
     * @return the head node of merged lists
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) { return null; }
        PriorityQueue<ListNode> smallTopHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for (ListNode list : lists) {
            if (list != null) { smallTopHeap.offer(list); }
        }

        ListNode fakeHead = new ListNode(0);
        ListNode curr, prev = fakeHead;
        while (!smallTopHeap.isEmpty()) {
            curr = smallTopHeap.poll();
            prev.next = curr;
            prev = curr;
            if (curr.next != null) {
                smallTopHeap.offer(curr.next);
            }
        }

        return fakeHead.next;
    }

    /**
     * Using recursive merge sort.
     *
     * 类似于归并排序，我们从上至下不断进行二分区，直到最底层包含两条链表或一条链表，然后自下而上进行合并两条链表。每一次层合并都需要遍历所有N个
     * 元素，总共有log2(k)层。
     *
     * Time Complexity: O(Nlogk)
     * Space Complexity: O(1)
     *
     * @param lists input list array
     * @return the head node of merged lists
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length-1);
    }

    private ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) { return lists[start]; }
        else if (start < end) {
            int pivot = start + ((end-start) >> 1);
            ListNode n1 = partition(lists, start, pivot);
            ListNode n2 = partition(lists, pivot+1, end);
            return merge(n1, n2);
        }
        else { return null; }
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null) { return n2; }
        if (n2 == null) { return n1; }

        if (n1.val <= n2.val) {
            n1.next = merge(n1.next, n2);
            return n1;
        }
        else {
            n2.next = merge(n1, n2.next);
            return n2;
        }
    }
}
