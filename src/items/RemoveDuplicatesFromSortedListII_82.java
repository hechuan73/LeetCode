package items;

public class RemoveDuplicatesFromSortedListII_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;

        while (null != head) {
            while (head.next != null && head.val == head.next.val) head = head.next;

            if (pre.next != head) pre.next = head.next;
            else pre = pre.next;

            head = head.next;
        }

        return fakeHead.next;
    }

//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null) return null;
//        ListNode newHead = new ListNode(0);
//        newHead.next = head;
//        ListNode lastNode = newHead, start = newHead;
//        boolean hasDuplicate = false;
//
//        while (null != head) {
//            if (head.val == lastNode.val) {
//                if (head.next == null) start.next = null;
//                hasDuplicate = true;
//            }
//            else {
//                if (hasDuplicate) {
//                    start.next = head;
//                    hasDuplicate = false;
//                }
//                else start = lastNode;
//            }
//            lastNode = head;
//            head = head.next;
//        }
//
//        return newHead.next;
//    }
}
