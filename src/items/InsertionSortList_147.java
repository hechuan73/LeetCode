package items;

public class InsertionSortList_147 {

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {return head;}

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = head, curr = head.next;
        ListNode next;

        while (curr != null) {
            // keep the sort stable and reduce the times of comparison
            if (curr.val >= prev.val) {
                prev = curr;
                curr = curr.next;
            }
            else {
                next = curr.next;
                ListNode prevNode = fakeHead, node = prevNode.next;
                while (node.val < curr.val ) {
                    prevNode = node;
                    node = node.next;
                }
                curr.next = node;
                prevNode.next = curr;

                curr = next;
                prev.next = curr;
            }
        }

        return fakeHead.next;
    }
}
