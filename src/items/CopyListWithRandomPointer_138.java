package items;

/**
 * @author hechuan
 */
public class CopyListWithRandomPointer_138 {

    public Node copyRandomList(Node head) {
        if (head == null) { return null; }
        Node curr = head, next;

        // copy nodes
        while (curr != null) {
            next = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = next;
            curr = next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) { curr.next.random = curr.random.next; }
            curr = curr.next.next;
        }

        curr = head;
        Node fakeHead = new Node(0), node = fakeHead;
        while (curr != null) {
            node.next = curr.next;
            node = node.next;
            curr.next = node.next;
            curr = curr.next;
        }

        return fakeHead.next;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int _val) {
            val = _val;
            next = null;
            random = null;
        }

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
