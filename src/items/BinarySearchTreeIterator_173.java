package items;

import java.util.Stack;

/**
 * @author hechuan
 */
public class BinarySearchTreeIterator_173 {

    private Stack<TreeNode> stack;

    public BinarySearchTreeIterator_173(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = stack.pop();
        if (res.right != null) {
            TreeNode node = res.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return res.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.isEmpty();
    }
}
