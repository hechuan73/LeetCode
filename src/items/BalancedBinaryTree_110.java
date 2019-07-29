package items;

/**
 * There are two approaches to solve this question which are "top down" and "bottom up".
 *
 * Approach 1: top down
 *     Firstly we checks whether the tree is balanced strictly according to the definition of balanced binary tree: the
 *     difference between the heights of the two sub trees are not bigger than 1, and both the left sub tree and right
 *     sub tree are also balanced. The function getDepth() is to get the depth of the current node.
 *
 *     For the current node root, calling getDepth() for its left and right children actually has to access all of its
 *     children, thus the complexity is O(N). We do this for each node in the tree, so the overall complexity of
 *     isBalanced will be O(N^2).
 *
 * Approach 2: bottom up
 *     This approach is based on DFS. Instead of calling getDepth() explicitly for each child node, we return the height
 *     of the current node in DFS recursion. When the sub tree of the current node (inclusive) is balanced, the function
 *     dfsHeight() returns a non-negative value as the height. Otherwise -1 is returned. According to the leftHeight and
 *     rightHeight of the two children, the parent node could check if the sub tree is balanced, and decides its return
 *     value.
 *
 *     In this approach, each node in the tree only need to be accessed once. Thus the time complexity is O(N), better
 *     than the first solution.
 */
public class BalancedBinaryTree_110 {

    // ==================================Approach 1=================================================================
    private boolean isBalanced1(TreeNode root) {
        if (null == root) return true;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        return (Math.abs(leftDepth - rightDepth) <= 1) && isBalanced1(root.left) && isBalanced1(root.right);
    }

    private static int getDepth(TreeNode root) {
        if (null == root) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right))+1;
    }

    // ===================================Approach 2================================================================

    public boolean isBalanced2(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    /**
     * Firstly, we calculate the children depth of the current node, and judge if they are balanced. If balanced, judge
     * the if the current node is balanced. If not, return -1 which means the tree is not balanced.
     * @param root root node
     * @return if the node is balanced. non-negative means it is balanced, -1 means it is not balanced.
     */
    public int dfsHeight(TreeNode root) {
        if (null == root) return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
