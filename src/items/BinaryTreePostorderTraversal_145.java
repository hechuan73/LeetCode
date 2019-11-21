package items;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author hechuan
 */
public class BinaryTreePostorderTraversal_145 {

    /**
     * Recursive method.
     *
     * @param root input tree root
     * @return value list with postorder
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    private void postOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            postOrder(root.left, res);
            postOrder(root.right, res);
            res.add(root.val);
        }
    }

    /**
     * Iterative method.
     *
     * @param root input tree root
     * @return value list with postorder
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) { return res; }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, right;

        while (curr != null || !stack.isEmpty()) {
            right = null;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.peek();
            if (curr.right == null) { res.add(stack.pop().val);}
            else {
                right = curr.right;
                // 避免重复访问子节点
                curr.right = null;
            }
            curr = right;
        }

        return res;
    }

    /**
     * Iterative method. (Tricky method)
     *
     * @param root input tree root
     * @return value list with postorder
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) { return ans; }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) { stack.push(cur.left); }
            if (cur.right != null) { stack.push(cur.right); }
        }

        return ans;
    }
}
