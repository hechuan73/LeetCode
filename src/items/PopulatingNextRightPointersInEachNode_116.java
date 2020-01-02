package items;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hechuan
 */
public class PopulatingNextRightPointersInEachNode_116 {

    /**
     * Simple DFS solution.
     * Notice: Require that the tree is a perfect/full binary tree.
     *
     * @param root input root node
     * @return the root node
     */
    public Node connect(Node root) {
        if (root == null || root.left == null) { return root; }
        connect(root.left, root.right);
        return root;
    }

    private void connect(Node left, Node right) {
        left.next = right;

        if (left.left != null) {
            connect(left.left, left.right);
            connect(left.right, right.left);
            connect(right.left, right.right);
        }
    }

    /**
     * Simple/General BFS solution.
     *
     * @param root input root node
     * @return the root node
     */
    public Node connect2(Node root) {
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
     * Optimised BFS solution.
     * Notice: Require that the tree is a perfect/full binary tree.
     *
     * @param root input root node
     * @return the root node
     */
    public Node connect3(Node root) {
        Node levelStart = root;
        Node curr;
        while (levelStart != null) {
            curr = levelStart;
            while (curr != null) {
                if (curr.left != null) { curr.left.next = curr.right; }
                if (curr.right != null && curr.next != null) { curr.right.next = curr.next.left; }

                curr = curr.next;
            }
            levelStart = levelStart.left;
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
