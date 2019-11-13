package items;

/**
 * @author hechuan
 */
public class SumOfLeftLeaves_404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) { return 0; }
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int res) {
        if (root.left != null) {
            // check if the left subtree is leaf node.
            if (root.left.left == null && root.left.right == null) { res += root.left.val; }
            res = dfs(root.left, res);
        }
        if (root.right != null) {
            res = dfs(root.right, res);
        }

        return res;
    }
}
