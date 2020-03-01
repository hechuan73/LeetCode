package items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hechuan
 */
public class LinkedListInBinaryTree_1367 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        Map<Integer, ArrayList<TreeNode>> map = new HashMap<>();
        traversal(root, map);

        ArrayList<TreeNode> nodes = null;
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
