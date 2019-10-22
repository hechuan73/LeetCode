package items;

import java.util.Stack;

/**
 * @author hechuan
 */
public class AddTwoNumbersII_445 {



    /**
     * Note: the number need to be not large than the maximum of the long type.
     *
     * @param l1 input list
     * @param l2 input list
     * @return the added list
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        long num1 = 0;
        while (l1 != null) {
            num1 = 10 * num1 + l1.val;
            l1 = l1.next;
        }

        long num2 = 0;
        while (l2 != null) {
            num2 = 10 * num2 + l2.val;
            l2 = l2.next;
        }

        long sum = num1 + num2;
        if (sum == 0) { return new ListNode(0); }
        ListNode node, prev = null;
        while (sum != 0) {
            int num = (int) (sum % 10);
            node = new ListNode(num);
            node.next = prev;
            prev = node;
            sum /= 10;
        }
        return prev;
    }

    /**
     * Using stack.
     * Note: no matter how long the list is, even if the value of the list is larger than the maximum of the long type,
     *       it can work.
     *
     * @param l1 input list
     * @param l2 input list
     * @return the added list
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0, sum = 0;
        ListNode node, prev = null;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            sum += carry;
            if (!stack1.isEmpty()) { sum += stack1.pop(); }
            if (!stack2.isEmpty()) { sum += stack2.pop(); }

            node = new ListNode(sum % 10);
            node.next = prev;
            prev = node;
            carry = sum / 10;
            sum = 0;
        }

        return prev;
    }
}
