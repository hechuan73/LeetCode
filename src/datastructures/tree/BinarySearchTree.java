package datastructures.tree;

import items.TreeNode;

/**
 * @author hechuan
 */
public class BinarySearchTree {

    private TreeNode search(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) { return root; }
            else if (root.val > val) { root = root.left; }
            else { root = root.right; }
        }

        return null;
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) { return null; }

        TreeNode node = root, prev = null;
        while (node != null) {
            prev = node;
            if (node.val > val) { node = node.left; }
            else { node = node.right; }
        }

        if (prev.val > val) { prev.left = new TreeNode(val); }
        else { prev.right = new TreeNode(val); }

        return root;
    }
}
