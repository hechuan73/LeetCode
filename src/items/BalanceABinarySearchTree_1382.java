package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class BalanceABinarySearchTree_1382 {

    /**
     * Tricky solution with sorted array and in-order traversal.
     *
     * @param root root node of the BST
     * @return the balance BST
     */
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedNodes = new ArrayList<>();
        inOrder(root, sortedNodes);
        return buildBSTWithSortedArray(sortedNodes, 0, sortedNodes.size()-1);
    }

    private void inOrder(TreeNode root, List<Integer> sortedNodes) {
        if (root != null) {
            inOrder(root.left, sortedNodes);
            sortedNodes.add(root.val);
            inOrder(root.right, sortedNodes);
        }
    }

    private TreeNode buildBSTWithSortedArray(List<Integer> sortedNodes, int start, int end) {
        if (start > end) { return null; }
        int mid = ((end-start)>>1) + start;
        TreeNode root = new TreeNode(sortedNodes.get(mid));
        root.left = buildBSTWithSortedArray(sortedNodes, start, mid-1);
        root.right = buildBSTWithSortedArray(sortedNodes, mid+1, end);
        return root;
    }
}
