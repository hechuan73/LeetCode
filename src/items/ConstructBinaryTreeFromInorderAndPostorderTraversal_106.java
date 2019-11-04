package items;

/**
 * @author hechuan
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {

    /**
     * 1. 后续数组最后一个值为树的根，构建根节点；
     * 2. 在中序数组中找到第一步中树的根，则前半部分为树的左子树中序数组，后半部分为树的右子树中序数组；
     * 3. 通过第二步，计算出左子树的节点数n，则可以在后序数组中确定出左子树的后序序列（根节点后的n个数即为左子树的后序数组部分，另一部分为右子树
     *    的后序数组部分）；
     * 4. 递归构建根节点的左子树和右子树。
     *
     * Note: 可以使用散列表来存储inorder数组的值，以便于每次不需要在遍历inorder来查找根节点在其中的位置，可以将时间复杂度降为O(n).
     *
     * Time Complexity: O(n*h)  best: O(nlogn)  worst: O(n^2)
     * Space Complexity: O(n/2)
     *
     * @param postorder the postorder array
     * @param inorder the inorder array
     * @return the tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) { return null; }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        int leftNum = index-inStart;
        root.left = build(inorder, inStart, index-1, postorder, postStart, postStart+leftNum-1);
        root.right = build(inorder, index+1, inEnd, postorder, postStart+leftNum, postEnd-1);
        return root;
    }
}
