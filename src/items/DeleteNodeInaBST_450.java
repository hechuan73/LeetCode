package items;

/**
 * @author hechuan
 */
public class DeleteNodeInaBST_450 {

    /**
     * 在二叉搜索（排序）树中，删除一个节点主要有三种情况：
     * 1. 该节点没有子节点，则可以直接删除，将其父节点的对应指针置为null即可；
     * 2. 该节点只有一个子节点（左或右子节点），将其父节点的对应指针指向该节点的子节点即可；
     * 3. 该节点有两个子节点，比较复杂。我们需要在其右子树中寻找最小的节点，然后用这个最小的节点来替换该节点，最后在删除掉这个最小的节点。因为
     *    最小的的节点，其左子树一定为空，即只包含0或1个子节点，我们可以应用1，2中的方式进行删除。同理，也可以在该节点的左子树中寻找最大的节点
     *    来替换该节点，操作类似。
     *
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     *
     * @param root the root node
     * @param key the delete key
     * @return the root node
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        // node points to the deleted node, and prev is its parent node.
        TreeNode node = root, prev = null;

        // find the node which need to be deleted
        while (node != null && node.val != key) {
            prev = node;
            if (node.val > key) { node = node.left; }
            else { node = node.right; }
        }

        if (node == null) { return root; }

        // if the deleted node has two child nodes, we need find the smallest node in its right subtree to replace it.
        if (node.left != null && node.right != null) {
            TreeNode curr = node.right, currPrev = node;
            // find the smallest node in the right child of the node which need to be deleted.
            while (curr.left != null) {
                currPrev = curr;
                curr = curr.left;
            }

            // set the smallest node value to the deleted node.
            node.val = curr.val;
            // reset the node and prev, the next operations will delete the (smallest) node.
            node = curr;
            prev = currPrev;
        }

        // delete the node, if the node has 0 or 1 child, node is node; otherwise the node is the smallest node in its right subtree.
        TreeNode child;
        if (node.left != null) { child = node.left; }
        else if (node.right != null) { child = node.right; }
        else { child = null; }

        // the delete node is the root node.
        if (prev == null) { root = child; }
        // the node is left child of its parent node.
        else if (prev.left == node) {prev.left = child;}
        // the node is right child of its parent node.
        else {prev.right = child; }

        return root;
    }
}
