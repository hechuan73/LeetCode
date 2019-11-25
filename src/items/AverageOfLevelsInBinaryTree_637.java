package items;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @author hechuan
 */
public class AverageOfLevelsInBinaryTree_637 {

    /**
     * BFS.
     *
     * @param root root node
     * @return average of each levels
     */
    public List<Double> averageOfLevels1(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) { return res; }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSize;
        double levelSum;
        TreeNode curr;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                curr = queue.poll();
                levelSum += curr.val;
                if (curr.left != null) { queue.offer(curr.left); }
                if (curr.right != null) { queue.offer(curr.right); }
            }
            res.add(levelSum / levelSize);
        }

        return res;
    }


    /**
     * DFS.
     *
     * @param root root node
     * @return average of each levels
     */
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<Integer> levelCount = new ArrayList<>();
        dfs(root, 0, res, levelCount);
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) / levelCount.get(i));
        }

        return res;
    }

    private void dfs(TreeNode root, int level, List<Double> res, List<Integer> levelCount) {
        if (root != null) {
            if (level >= res.size()) {
                res.add(root.val+0.0);
                levelCount.add(1);
            }
            else {
                res.set(level, res.get(level) + root.val);
                levelCount.set(level, levelCount.get(level) + 1);
            }

            dfs(root.left, level+1, res, levelCount);
            dfs(root.right, level+1, res, levelCount);
        }
    }
}
