package items;

/**
 * @author hechuan
 */
public class CountCompleteTreeNodes_222 {

    /**
     * Using recursive or iteration method can count the nodes of the tree within O(n). How to optimize?
     *
     * Using the height of the tree:
     * 1. Calculate the height h1 of the tree.
     * 2. Calculate the height h2 of the right subtree.
     * 3. If h2 = h1-1, means that the last node resides in the right subtree, and the left subtree is also a fulfill
     *    tree. And a fulfill tree with height h has 2^(h+1)-1 nodes, so if the root node is h, and its left subtree is
     *    a fulfill tree, the left subtree will contains 2^h-1 nodes, considerate the root node, it will be 2^h nodes.
     *    Then we traverse the right subtree iteratively.
     *
     *    If h2 < h1-1, means that the last node resides in the left subtree, and the right subtree with height h1-2 is
     *    also a fulfill tree, and contains 2^(h-1)-1 nodes, considerate the root node, it will be 2^(h-1) nodes. Then
     *    we traverse the left subtree iteratively.
     *
     * Time Complexity: O((logn)^2)
     * Space Complexity: O(1)
     *
     * @param root root node
     * @return the nodes of complete binary tree
     */
    public int countNodes(TreeNode root) {
        int res = 0, h = height(root);
        while (root != null) {
            if (height(root.right) == h-1) {
                res += (1 << h);
                root = root.right;
            }
            else {
                res += (1 << (h-1));
                root = root.left;
            }
            h--;
        }

        return res;
    }

    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
}
