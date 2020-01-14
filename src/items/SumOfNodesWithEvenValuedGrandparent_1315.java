package items;

/**
 * @author hechuan
 */
public class SumOfNodesWithEvenValuedGrandparent_1315 {

    private int sum;

    /**
     * Simple dfs solution.
     *
     * @param root root node of the tree
     * @return the sum of nodes with even grand parents
     */
    public int sumEvenGrandparent1(TreeNode root) {
        sum = 0;
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            if ((root.val & 1) == 0) {
                if (root.left != null) {
                    if (root.left.left != null) { sum += root.left.left.val; }
                    if (root.left.right != null) { sum += root.left.right.val; }
                }

                if (root.right != null) {
                    if (root.right.left != null) { sum += root.right.left.val; }
                    if (root.right.right != null) { sum += root.right.right.val; }
                }
            }
            dfs(root.left);
            dfs(root.right);
        }
    }


    /**
     * Optimised dfs solution. Let children know whether their grandparent is even.
     * 1. Assume root has parent.val = 1 and grandparent.val = 1.
     * 2. Recursive iterate the whole tree and pass on the value of parent and grandparent.
     * 3. Count the root.val when grandparent is even-valued.
     *
     * @param root root node of the tree
     * @return the sum of nodes with even grand parents
     */
    public int sumEvenGrandparent(TreeNode root) {
        return helper(root, 1, 1);
    }

    private int helper(TreeNode root, int p, int gp) {
        if (root == null) { return 0;}
        return helper(root.left, root.val, p) + helper(root.right, root.val, p) + ((gp & 1) == 0 ? root.val : 0);
    }
}
