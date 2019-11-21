package items;

/**
 * @author hechuan
 */
public class FindModeInBinarySearchTree_501 {

    public int[] findMode(TreeNode root) {
        // find the maximum occurrence of node value.
        inorder(root);
        // init result array
        modes = new int[modeCount];
        // reset parameter
        modeCount = 0;
        currCount = 0;
        currVal = 0;
        // find if the occurrence of node is equal to the maxCount.
        inorder(root);
        return modes;
    }

    private int currVal = 0;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;
    private int[] modes;

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            handle(root.val);
            inorder(root.right);
        }
    }

    private void handle(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;

        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        }
        else if (currCount == maxCount) {
            if (modes != null) { modes[modeCount] = currVal; }
            modeCount++;
        }
    }
}
