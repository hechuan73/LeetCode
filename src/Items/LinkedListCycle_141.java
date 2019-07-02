package Items;

public class LinkedListCycle_141 {

    /**
     * Use two runner which have different speed. The fast one runs 2 steps per time, while the slow one runs 1 step.
     * If there is a cycle, they will meet eventually. If not, the fast one will arrive at the destination and return
     * false.
     *
     * @param head head node
     * @return whether the list has a cycle.
     */
    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) return false;

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }
}
