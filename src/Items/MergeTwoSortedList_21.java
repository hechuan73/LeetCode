package Items;

public class MergeTwoSortedList_21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode(0);
        ListNode pre = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                pre.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = l1 == null ? l2 : l1;
        return  result;
    }
}
