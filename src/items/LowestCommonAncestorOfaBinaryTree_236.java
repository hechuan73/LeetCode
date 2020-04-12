package items;

/**
 * @author hechuan
 */
public class LowestCommonAncestorOfaBinaryTree_236 {

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) { return null; }
        int curr = (root.val == p.val || root.val == q.val) ? 1 : 0;
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);

        if (curr + left + right >= 2) { return root; }
        if (left == 0) { return helper(root.right, p, q); }
        else { return helper(root.left, p, q); }
    }

    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) { return 0; }
        if (root.val == p.val || root.val == q.val) { return 1; }
        if (dfs(root.left, p, q) > 0) { return 1; }
        if (dfs(root.right, p, q) > 0) { return 1; }
        return 0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { return root; }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) { return null; }
        if (left == null) { return right; }
        if (right == null) { return left; }
        return root;
    }
}
