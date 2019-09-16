package items;

public class PartitionList_86 {

    public ListNode partition(ListNode head, int x) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode cur = head, prev = fakeHead, next;
        ListNode lastInsertNode = fakeHead;

        while (cur != null) {
            next = cur.next;
            if (cur.val < x) {
                if (prev != lastInsertNode) {
                    cur.next = lastInsertNode.next;
                    lastInsertNode.next = cur;
                    prev.next = next;
                }
                else { prev = cur;}
                lastInsertNode = cur;
            }
            else { prev = cur; }
            cur = next;
        }

        return fakeHead.next;
    }
}
