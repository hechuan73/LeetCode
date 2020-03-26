package items;

/**
 * @author hechuan
 */
public class ReverseNodesInkGroup_25 {

    /**
     * Simple solution in straight forward.
     *
     * @param head input head node
     * @param k group limit number
     * @return the root node of group reversed list
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) { return head; }

        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        if (len < k) { return head;}

        ListNode fakeHead = new ListNode(0);
        // prev is the prev node in each group, initial value is null.
        // next is the next node in each group.
        // tmpFirst is the first node in each group.
        // tmpLast is the last node in last group.
        ListNode prev = null, next, tmpFirst, tmpLast = fakeHead;
        curr = head;
        int tmpK;
        while (len >= k && curr != null) {
            tmpK = k;
            tmpFirst = curr;

            while (tmpK > 0 && curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                tmpK--;
            }
            tmpLast.next = prev;
            prev = tmpFirst;
            tmpLast = tmpFirst;
            // connect the current group ane the remain nodes.
            tmpLast.next = curr;
            len -= k;
        }

        return fakeHead.next;
    }

}
