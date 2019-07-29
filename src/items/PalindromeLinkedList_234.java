package items;

public class PalindromeLinkedList_234 {

    /**
     * Use two pointer with different speed, one step for slow pointer and two steps for the fast one. Traverse the
     * linked list and find the middle node. Also with the slow pointer going, modify its 'next' pointer to reverse the
     * order of the first half of the list. Then compare the value of the nodes which lie in the two sides of the middle
     * node.
     *
     * @param head head node
     * @return if the singly linked list is a palindrome
     */
    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        ListNode prev = null, next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if (fast != null) slow = slow.next;

        while (slow != null && prev != null) {
            if (slow.val != prev.val) return false;
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }
}
