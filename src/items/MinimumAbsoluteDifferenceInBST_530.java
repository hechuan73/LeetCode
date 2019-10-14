package items;

/**
 * @author hechuan
 */
public class MinimumAbsoluteDifferenceInBST_530 {

    private long res = Integer.MAX_VALUE, prev = Integer.MIN_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return (int) res;
    }

    private void inorder(TreeNode node) {
        if (node.left != null) { inorder(node.left); }
        res = Math.min(res, (node.val-prev));
        prev = node.val;
        if (node.right != null) { inorder(node.right); }
    }
}
