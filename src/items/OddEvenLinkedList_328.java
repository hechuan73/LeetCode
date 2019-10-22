package items;

/**
 * @author hechuan
 */
public class OddEvenLinkedList_328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) { return null; }
        int count = 2;
        // if we create a fakeNode as the first node, it will be error on the node 'head' which is the real first node
        // so we do not do that, and start from the second node 'curr = head.next'.
        ListNode prev = head, curr = head.next, lastOdd = head;
        ListNode lastOddNext, currNext;

        while (curr != null) {
            if (count++ % 2 == 0) {
                prev = curr;
                curr = curr.next;
            }
            else {
                lastOddNext = lastOdd.next;
                currNext = curr.next;
                lastOdd.next = curr;
                curr.next = lastOddNext;
                lastOdd = curr;
                prev.next = currNext;
                curr = currNext;
            }
        }

        return head;
    }
}
