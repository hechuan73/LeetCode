package items;

public class RemoveLinkedListElements_203 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode cur = head, prev = fakeHead;

        while (cur != null) {
            if (cur.val == val) { prev.next = cur.next; }
            else { prev = cur; }
            cur = cur.next;
        }

        return fakeHead.next;
    }
}
