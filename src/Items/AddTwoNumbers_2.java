package Items;

public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (null == l1 && null == l2) {
            if (carry == 0)
                return null;
            return new ListNode(1);
        } else if (null == l1) {
            carry += l2.val;
            l2.val = carry % 10;
            l2.next = addTwoNumbers(null, l2.next, carry / 10);
            return l2;
        } else if (null == l2) {
            carry += l1.val;
            l1.val = carry % 10;
            l1.next = addTwoNumbers(l1.next, null, carry / 10);
            return l1;
        } else {
            carry += l1.val + l2.val;
            l2.val = carry % 10;
            l2.next = addTwoNumbers(l1.next, l2.next, carry / 10);
            return l2;
        }

    }
}