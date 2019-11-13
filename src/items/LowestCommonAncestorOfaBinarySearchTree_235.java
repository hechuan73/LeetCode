package items;

/**
 * @author hechuan
 */
public class LowestCommonAncestorOfaBinarySearchTree_235 {

    /**
     * Recursive method
     *
     * @param root the root node
     * @param p node p
     * @param q node q
     * @return the lowest common ancestor
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) { return null; }

        if (root.val > p.val && root.val > q.val) { return lowestCommonAncestor(root.left, p, q); }
        else if (root.val < p.val && root.val < q.val) { return lowestCommonAncestor(root.right, p, q); }
        else { return root; }
    }


    /**
     * Iterative method
     *
     * @param root the root node
     * @param p node p
     * @param q node q
     * @return the lowest common ancestor
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) { root = root.left; }
            else if (root.val < p.val && root.val < q.val) { root = root.right; }
            else { return root; }
        }

        return null;
    }

}
