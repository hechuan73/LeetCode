package items;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author hechuan
 */
public class ValidateBinarySearchTree_98 {

    /**
     * Traversing inorder with stack.
     *
     * @param root the root node of the tree
     * @return whether the tree is a BST
     */
    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode prev = null;
        while (!nodes.isEmpty() || root != null) {
            while (root != null) {
                nodes.push(root);
                root = root.left;
            }

            root = nodes.pop();
            if (prev != null && root.val <= prev.val) { return false; }
            prev = root;
            root = root.right;
        }

        return true;
    }


    /**
     * Recursive traversing.
     *
     * @param root the root node of the tree
     * @return whether the tree is a BST
     */
    public boolean isValidBST2(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long prev, long next) {
        if (root == null) { return true; }
        if (root.val <= prev || root.val >= next) { return false; }

        return isValid(root.left, prev, root.val) && isValid(root.right, root.val, next);
    }

    private LinkedList<TreeNode> stack = new LinkedList<>();
    private LinkedList<Integer> uppers = new LinkedList<>(), lowers = new LinkedList<>();

    /**
     * Iteration traversing instead of the recursive traversing based on the stack.
     *
     * @param root the root node of the tree
     * @return whether the tree is a BST
     */
    public boolean isValidBST3(TreeNode root) {
        Integer lower = null, upper = null, val;
        update(root, lower, upper);

        while (!stack.isEmpty()) {
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();

            if (root == null) continue;
            val = root.val;
            if (lower != null && val <= lower) return false;
            if (upper != null && val >= upper) return false;
            update(root.right, val, upper);
            update(root.left, lower, val);
        }
        return true;
    }

    private void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }
}
