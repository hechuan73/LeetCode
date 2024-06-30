package items;

public class RecoverBinarySearchTree_99 {

    private TreeNode t1, t2, prev = null;

    /**
     * 如果对两个节点交换了顺序，那一定有两个地方是不满足：前一个元素 < 当前元素 < 后一个元素
     * @param root root
     */
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }

    public void inOrder(TreeNode root) {
        if (null != root) {
            inOrder(root.left);
            // 找到逆序对
            if (null != prev && prev.val > root.val) {
                if (null == t1) { t1 = prev; }
                t2 = root;
            }

            prev = root;
            inOrder(root.right);
        }
    }
}
