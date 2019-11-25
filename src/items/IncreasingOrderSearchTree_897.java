package items;

/**
 * @author hechuan
 */
public class IncreasingOrderSearchTree_897 {

    /**
     * Relink the input tree without extra space
     *
     * @param root the root node of the tree.
     * @return the root node of increasing tree
     */
    public TreeNode increasingBST1(TreeNode root) {
        return increasingBST(root, null);
    }

    private TreeNode increasingBST(TreeNode root, TreeNode prev) {
        // if this null node was a left child, tail is its parent
        // if this null node was a right child, tail is its parent's parent
        if (root == null) { return prev; }

        // recursive call, traversing left while passing in the current node as tail
        TreeNode res = increasingBST(root.left, root);
        // set left child to null
        root.left = null;

        // we set the current node's right child to be tail
        // what is tail? this part is important
        // if the current node is a left child, tail will be its parent
        // else if the current node is a right child, tail will be its parent's parent
        root.right = increasingBST(root.right, prev);

        // throughout the whole algorithm, res is the leaf of the leftmost path in the original tree
        // its the smallest node and thus will be the root of the modified tree
        return res;
    }

    /**
     * Rebuild the increasing tree with inorder traversal and storing nodes in list.
     *
     * @param root the root node of the tree.
     * @return the root node of increasing tree
     */
    public TreeNode increasingBST2(TreeNode root) {
        return root;
    }
}
