package items;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hechuan
 */
public class MaximumLevelSumOfaBinaryTree_1161 {

    /**
     * BFS.
     *
     * @param root root node of the tree
     * @return the level with maximum sum
     */
    public int maxLevelSum1(TreeNode root) {
        int res = 0;
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            TreeNode curr;
            int levelLen, level = 1, sum, max = Integer.MIN_VALUE;
            while (!queue.isEmpty()) {
                levelLen = queue.size();
                sum = 0;
                while (levelLen-- > 0) {
                    curr = queue.poll();
                    sum += curr.val;
                    if(curr.left != null) { queue.add(curr.left); }
                    if (curr.right != null) { queue.add(curr.right); }
                }
                if (sum > max) {
                    res = level;
                    max = sum;
                }
                level++;
            }
        }

        return res;
    }

    /**
     * DFS.
     *
     * @param root root node of the tree
     * @return the level with maximum sum
     */
    public int maxLevelSum(TreeNode root) {
        List<Integer> levelSums = new ArrayList<>();
        dfs(root, 0, levelSums);
        // return 1 + IntStream.range(0, levelSums.size()).reduce(0, (a, b) -> levelSums.get(a) < levelSums.get(b) ? b : a);
        int res = 0;
        for (int i = 1; i < levelSums.size(); i++) {
            if (levelSums.get(i) > levelSums.get(res)) { res = i; }
        }

        return res + 1;
    }

    private void dfs(TreeNode root, int depth, List<Integer> levelSums) {
        if (root != null) {
            if (depth >= levelSums.size()) { levelSums.add(root.val); }
            else { levelSums.set(depth, levelSums.get(depth) + root.val); }

            dfs(root.left, depth+1, levelSums);
            dfs(root.right, depth+1, levelSums);
        }
    }
}
