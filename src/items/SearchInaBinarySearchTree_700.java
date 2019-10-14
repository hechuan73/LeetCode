package items;

/**
 * @author hechuan
 */
public class SearchInaBinarySearchTree_700 {

    public TreeNode searchBST(TreeNode root, int val) {

        while (root != null) {
            if (root.val == val) { return root; }
            else if (root.val > val) { root = root.left; }
            else { root = root.right; }
        }

        return null;
    }
}
