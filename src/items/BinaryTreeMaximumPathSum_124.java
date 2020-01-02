package items;

/**
 * @author hechuan
 */
public class BinaryTreeMaximumPathSum_124 {

    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) { return 0; }
        // if the sum of left/right subtree is negative, drop it as 0.
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        // update the maximum value.
        max = Math.max(max, left+right+root.val);
        // return the maximum value of left and right subtree to the up-level to count more.
        return Math.max(left, right) + root.val;
    }
}
