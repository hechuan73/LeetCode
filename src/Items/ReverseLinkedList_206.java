package Items;

public class ReverseLinkedList_206 {

    public ListNode reverseList(ListNode head) {
        ListNode next, prev = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
