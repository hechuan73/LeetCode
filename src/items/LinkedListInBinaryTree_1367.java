package items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hechuan
 */
public class LinkedListInBinaryTree_1367 {

    /**
     * Simple recursive solution.
     *
     * @param head the head of the linked list
     * @param root the root of the tree
     * @return whether there is a path of the linked list in the tree.
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) { return true; }
        if (root == null) { return false; }

        return check(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }


    public boolean isSubPath2(ListNode head, TreeNode root) {
        Map<Integer, ArrayList<TreeNode>> map = new HashMap<>();
        traversal(root, map);

        ArrayList<TreeNode> nodes;
        if ((nodes = map.get(head.val)) == null || nodes.isEmpty()) { return false; }

        ListNode target;
        TreeNode curr;
        for (TreeNode node : nodes) {
            target = head.next;
            curr = node;
            if (check(curr.left, target) || check(curr.right, target)) {
                return true;
            }
        }

        return false;
    }

    private void traversal(TreeNode root, Map<Integer, ArrayList<TreeNode>> map) {
        if (root != null) {
            if (!map.containsKey(root.val)) { map.put(root.val, new ArrayList<>()); }
            map.get(root.val).add(root);
            traversal(root.left, map);
            traversal(root.right, map);
        }
    }

    private boolean check(TreeNode root, ListNode head) {
        if (head == null) { return true; }
        if (root == null) { return false; }
        if (root.val == head.val) { return check(root.left, head.next) || check(root.right, head.next); }
        return false;
    }



}
