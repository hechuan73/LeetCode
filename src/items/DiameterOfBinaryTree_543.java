package items;

/**
 * @author hechuan
 */
public class DiameterOfBinaryTree_543 {

    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root)[0];
    }

    /**
     * DFS. Using array to store two values: current height and best.
     * Since the best diameter can not pass the root node, so the recursive body is the tree of root, left node and
     * right node. Then the best diameter is the maximum of the three nodes one.
     *
     * @param root the root node
     * @return [best, height]
     */
    private int[] dfs(TreeNode root) {
        if (root == null) { return new int[] {0, 0}; }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // calculate the maximum diameter in the three nodes.
        int best = Math.max(left[1] + right[1], Math.max(left[0], right[0]));
        int height = 1 + Math.max(left[1], right[1]);
        return new int[] { best, height};
    }
}
