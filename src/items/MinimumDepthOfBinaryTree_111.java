package items;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hechuan
 */
public class MinimumDepthOfBinaryTree_111 {

    /**
     * Using DFS.
     *
     * Note: the leaf node is that both the left and right are null.
     *
     * @param root the root node
     * @return the minimum depth of the tree
     */
    public int minDepth1(TreeNode root) {
        if (root == null) { return 0; }
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);

        return (left == 0 || right == 0) ? (left + right + 1) : (Math.min(left, right) + 1);
    }

    /**
     * Using BFS.
     *
     * Note: the leaf node is that both the left and right are null.
     *
     * @param root the root node
     * @return the minimum depth of the tree
     */
    public int minDepth2(TreeNode root) {
        if (root == null) { return 0; }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int res = 1, size;
        TreeNode curr;
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size > 0){
                curr = queue.poll();
                if (curr.left == null && curr.right == null) { return res; }
                if (curr.left != null) { queue.offer(curr.left); }
                if (curr.right != null) { queue.offer(curr.right); }
                size--;
            }
            res++;
        }

        return res;
    }

}
