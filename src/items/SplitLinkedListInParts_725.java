package items;

/**
 * @author hechuan
 */
public class SplitLinkedListInParts_725 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode curr = root;
        // get the length of the list
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        int base = len / k;
        int remainder = len % k;

        ListNode[] res = new ListNode[k];
        ListNode next = null;
        curr = root;
        int i;
        for (i = 0; i < k; i++) {
            res[i] = curr;
            // cut the base nodes
            for (int j = 1; j < base; j++) {
                curr = curr.next;
            }
            // arrange the remainder nodes
            if (base != 0 && remainder-- > 0) {
                curr = curr.next;
            }

            if (curr != null) {
                next = curr.next;
                // cut the list to start new segment
                curr.next = null;
                curr = next;
            }
        }

        return res;
    }
}
