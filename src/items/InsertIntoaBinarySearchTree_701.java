package items;

/**
 * @author hechuan
 */
public class InsertIntoaBinarySearchTree_701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root, prev = null;

        while (node != null) {
            prev = node;
            if (node.val > val) { node = node.left; }
            else { node = node.right; }
        }

        if (prev.val > val) { prev.left = new TreeNode(val); }
        else { prev.right = new TreeNode(val); }

        return root;
    }
}
