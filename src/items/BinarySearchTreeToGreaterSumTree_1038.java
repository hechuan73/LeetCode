package items;

/**
 * @author hechuan
 */
public class BinarySearchTreeToGreaterSumTree_1038 {

    private int prev = 0;

    /**
     * Approach: We can traverse the binary tree from the big to the small, from the right to the left, because for a
     *           unique node, the nodes in its right child is bigger than it, so when we traverse, we count the greater
     *           value in 'prev', and for each node, its new value is equal to the 'prev' plus to its old value.
     *
     * @param root the root node
     * @return the root node
     */
    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) { bstToGst(root.right); }
        root.val += prev;
        prev = root.val;
        if (root.left != null) { bstToGst(root.left);}

        return root;
    }
}
