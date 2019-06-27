package Items;

public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return pathSum(root, sum, 0);
    }

    public boolean pathSum(TreeNode root, int sum, int curSum) {
        if (root == null) return false;
        if (curSum+root.val == sum) {
            // return true only when
            // 1. currentSum == sum;
            // 2. root.left == null && root.right == null.
            if (root.left == null && root.right == null) return true;
        }

        return pathSum(root.left, sum, curSum+root.val)
                || pathSum(root.right, sum, curSum+root.val);
    }
}
