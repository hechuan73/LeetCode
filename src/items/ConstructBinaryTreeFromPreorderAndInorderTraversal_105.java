package items;

/**
 * @author hechuan
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

    /**
     * 1. 前序数组第一个值为树的根，构建根节点；
     * 2. 在中序数组中找到第一步中树的根，则前半部分为树的左子树中序数组，后半部分为树的右子树中序数组；
     * 3. 通过第二步，计算出左子树的节点数n，则可以在前序数组中确定出左子树的前序序列（根节点后的n个数即为左子树的前序数组部分，另一部分为右子树
     *    的前序数组部分）；
     * 4. 递归构建根节点的左子树和右子树。
     *
     * Note: 可以使用散列表来存储inorder数组的值，以便于每次不需要在遍历inorder来查找根节点在其中的位置，可以将时间复杂度降为O(n).
     *
     * Time Complexity: O(n*h)  best: O(nlogn)  worst: O(n^2)
     * Space Complexity: O(n/2)
     *
     * @param preorder the preorder array
     * @param inorder the inorder array
     * @return the tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) { return null; }

        TreeNode root = new TreeNode(preorder[preStart]);
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        // calculate node number of the left child tree
        int leftNum = index-inStart;
        // the preStart and preEnd should be calculate based on the leftNum, instead of index directly, because if a
        // tree don't have left/right child tree, the preorder and inorder array moving in different direction.
        root.left = build(preorder, preStart+1, preStart+leftNum, inorder, inStart, index-1);
        root.right = build(preorder, preStart+leftNum+1, preEnd, inorder, index+1, inEnd);
        return root;
    }
}
