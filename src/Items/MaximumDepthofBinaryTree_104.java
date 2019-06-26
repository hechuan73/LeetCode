package Items;

public class MaximumDepthofBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftLength = 1, rightLength = 1;
        if (root.left != null) leftLength += maxDepth(root.left);
        if (root.right != null) rightLength += maxDepth(root.right);

        return Math.max(leftLength, rightLength);
    }
}
