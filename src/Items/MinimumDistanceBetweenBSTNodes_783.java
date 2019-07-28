package Items;

public class MinimumDistanceBetweenBSTNodes_783 {

    private int diff = Integer.MAX_VALUE;
    private Integer prev;
    public int minDiffInBST(TreeNode root) {
        if (root != null) {
            minDiffInBST(root.left);
            if (prev != null) diff = Math.min(diff, root.val-prev);
            prev = root.val;
            minDiffInBST(root.right);
        }

        return diff;
    }
}
