package items;

/**
 * @author hechuan
 */
public class SymmetricTree_101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) { return true; }
        return valid(root.left, root.right);
    }

    private boolean valid(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) { return true; }
        if (root1 == null) { return false; }
        if (root2 == null) { return false; }
        if (root1.val != root2.val) { return false; }

        return valid(root1.left, root2.right) && valid(root1.right, root2.left);
    }
}
