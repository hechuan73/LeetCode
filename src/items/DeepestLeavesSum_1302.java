package items;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hechuan
 */
public class DeepestLeavesSum_1302 {

    /**
     * Simple BFS solution.
     *
     * @param root the root node of the tree
     * @return the sum of the deepest leaves of the tree
     */
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) { return 0; }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int levelSize, levelSum = 0;
        TreeNode curr;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            levelSum = 0;
            for (int i = levelSize; i > 0; i--) {
                curr = queue.poll();
                levelSum += curr.val;
                if (curr.left != null) { queue.add(curr.left); }
                if (curr.right != null) { queue.add(curr.right); }
            }
        }

        return levelSum;
    }
}
