package items;

public class RotateList_61 {

    /**
     * 1. We need to know the length of linked list.
     * 2. Move the list after the (length-k%length )th node to the front to finish the rotation.
     *
     * @param head the head node
     * @param k the rotation times
     * @return the head node
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || null == head.next) {return head;}

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode cur = head, node;

        // get the length of the list
        int length = 1;
        while (null != cur.next) {
            ++length;
            cur = cur.next;
        }

        // get the index of rotation
        int index = length - (k % length);

        // find the prev of the rotation node, from head to the prev.
        node = head;
        for (int i = index; i > 1; i--) { node = node.next; }

        // do rotation
        cur.next = fakeHead.next;
        fakeHead.next = node.next;
        node.next = null;

        return fakeHead.next;
    }
}
