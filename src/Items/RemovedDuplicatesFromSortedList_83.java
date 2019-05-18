package Items;

public class RemovedDuplicatesFromSortedList_83 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode lastNode = null, result = head;
        while (null != head) {
            if (null == lastNode) {
                lastNode = head;
                head = head.next;
            }
            else {
                if (head.val == lastNode.val)
                    lastNode.next = head.next;
                else lastNode = head;
                head = head.next;
            }
        }
        return result;
    }
}
