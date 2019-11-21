package items;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hechuan
 */
public class FindBottomLeftTreeValue_513 {

    /**
     * BFS: From right to left, and the last node must be the bottom left node.
     *
     * @param root the root node
     * @return value of the bottom left node
     */
    public int findBottomLeftValue1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) { queue.offer(root.right); }
            if (root.left != null) { queue.offer(root.left); }
        }

        return root.val;
    }

    /**
     * DFS: Check if the current node is the deepest node. From left to right, so if some nodes are in the same depth,
     *      we can get the leftest node.
     *
     * @param root the root node
     * @return value of the bottom left node
     */
    public int findBottomLeftValue2(TreeNode root) {
        return dfs(root, 1, new int[]{0, 0});
    }

    private int dfs(TreeNode root, int currDepth, int[] deepestNodeInfo) {
        if (currDepth > deepestNodeInfo[1]) { deepestNodeInfo[0] = root.val; deepestNodeInfo[1] = currDepth; }
        if (root.left != null) { dfs(root.left, currDepth+1, deepestNodeInfo); }
        if (root.right != null) { dfs(root.right, currDepth+1, deepestNodeInfo); }
        return deepestNodeInfo[0];
    }
}
