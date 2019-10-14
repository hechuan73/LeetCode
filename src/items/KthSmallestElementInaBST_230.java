package items;

import java.util.Stack;

/**
 * @author hechuan
 */
public class KthSmallestElementInaBST_230 {

    int count, res = 0;
    public int kthSmallest2(TreeNode root, int k) {
        count = k;
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root) {
        if (count == 0) { return; }
        if (root.left != null) { inorder(root.left); }
        if (--count == 0) {
            res = root.val;
            return;
        }

        if (root.right != null) { inorder(root.right); }
    }

    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        // inorder traverse.
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            if (--k == 0) { return root.val; }
            root = root.right;
        }
    }

}
