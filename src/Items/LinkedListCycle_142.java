package Items;

public class LinkedListCycle_142 {
    public ListNode detectCycle(ListNode head) {
        if (null == head || null == head.next) return null;

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
