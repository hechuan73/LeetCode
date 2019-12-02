package items;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hechuan
 */
public class InvertBinaryTree_226 {

    /**
     * DFS.
     * @param root root node of the tree
     * @return root node of the inverted tree
     */
    public TreeNode invertTree1(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
            invert(root.left);
            invert(root.right);
        }
    }

    /**
     * BFS.
     *
     * @param root root node of the tree
     * @return root node of the inverted tree
     */
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            TreeNode curr, tmp;
            while (!queue.isEmpty()) {
                curr = queue.poll();
                tmp = curr.left;
                curr.left = curr.right;
                curr.right = tmp;
                if(curr.left != null) { queue.add(curr.left); }
                if(curr.right != null) { queue.add(curr.right); }
            }
        }

        return root;
    }
}
