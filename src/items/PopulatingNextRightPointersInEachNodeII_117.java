package items;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hechuan
 */
public class PopulatingNextRightPointersInEachNodeII_117 {

    /**
     * Simple/General BFS solution.
     *
     * @param root input root node
     * @return the root node
     */
    public Node connect1(Node root) {
        if (root == null) { return root; }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node curr, prev = null;
        int len;
        while (!queue.isEmpty()) {
            len = queue.size();
            for (int i = 0; i < len; i++) {
                curr = queue.poll();
                if (curr.left != null) { queue.add(curr.left); }
                if (curr.right != null) { queue.add(curr.right); }
                if (i > 0) { prev.next = curr; }
                prev = curr;
            }
        }

        return root;
    }

    /**
     * Optimised BFS solution with double loop.
     *
     * @param root input root node
     * @return the root node
     */
    public Node connect2(Node root) {
        // the left most node in the lower level.
        Node head = root;
        // the previous node in the lower level.
        Node prev;
        // the current node in the upper level.
        Node curr;

        while (head != null) {
            curr = head;
            prev = null;
            head = null;
            while (curr != null) {
                if (curr.left != null) {
                    if (prev != null) { prev.next = curr.left; }
                    else { head = curr.left; }
                    prev = curr.left;
                }

                if (curr.right != null) {
                    if (prev != null) { prev.next = curr.right; }
                    else { head = curr.right; }
                    prev = curr.right;
                }

                curr = curr.next;
            }
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
