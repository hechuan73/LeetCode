package items;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * There are three approaches to traverse binary tree with inorder.
 * 1. Recursive method.
 * 2. Iterating method using stack.
 * 3. Morris traversal.
 *
 * Here I use the 2nd method.
 */
public class BinaryTreeInorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> elements = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !elements.isEmpty()) {
            while (cur != null) {
                elements.push(cur);
                cur = cur.left;
            }

            cur = elements.pop();
            result.add(cur.val);
            cur = cur.right;
        }

        return result;
    }
}
