package items;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hechuan
 */
public class BinaryTreePreorderTraversal_144 {

    /**
     * Recursive method.
     *
     * @param root input tree root
     * @return value list with preorder
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            preorder(root.left, res);
            preorder(root.right, res);
        }
    }

    /**
     * Iterative method.
     *
     * @param root input tree root
     * @return value list with preorder
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) { return res; }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            res.add(curr.val);
            if (curr.right != null) { stack.push(curr.right); }
            if (curr.left != null) { stack.push(curr.left);}
        }

        return res;
    }
}
