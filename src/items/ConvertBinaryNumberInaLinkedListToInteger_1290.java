package items;

/**
 * @author hechuan
 */
public class ConvertBinaryNumberInaLinkedListToInteger_1290 {

    /**
     * Simple method with double traversal.
     *
     * @param head the head node with the list
     * @return the decimal value of the list
     */
    public int getDecimalValue1(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }

        curr = head;
        int res = 0, pow = len;
        while (curr != null) {
            res += curr.val << (pow-1);
            pow--;
            curr = curr.next;
        }

        return res;
    }

    /**
     * Bitwise operations:
     *     ans = ans * 2 + head.val; <=> ans = (ans << 2) | head.val;
     *
     * @param head the head node with the list
     * @return the decimal value of the list
     */
    public int getDecimalValue2(ListNode head) {
        int res = 0;
        ListNode curr = head;
        while (curr != null) {
            res = (res << 1) | curr.val;
            curr = curr.next;
        }

        return res;
    }
}
