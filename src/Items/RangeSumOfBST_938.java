package Items;

public class RangeSumOfBST_938 {

    public int rangeSumBST(TreeNode root, int L, int R) {
        return dfs(root, 0, L, R);
    }

    private int dfs(TreeNode node, int sum, int L, int R) {
        if (node != null) {
            if (node.val >= L && node.val <= R)
                sum += node.val;
            if (L < node.val)
                sum = dfs(node.left, sum, L, R);
            if (node.val < R)
                sum = dfs(node.right, sum, L, R);
        }

        return sum;
    }
}
