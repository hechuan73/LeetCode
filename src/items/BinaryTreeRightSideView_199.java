package items;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hechuan
 */
public class BinaryTreeRightSideView_199 {

    /**
     * BFS.
     *
     * @param root the root node of the tree
     * @return the right side view of the list
     */
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int levelLen;
            TreeNode curr = root;
            while (!queue.isEmpty()) {
                levelLen = queue.size();
                while (levelLen-- > 0) {
                    curr = queue.poll();
                    if (curr.left != null) { queue.offer(curr.left); }
                    if (curr.right != null) { queue.offer(curr.right); }
                }
                res.add(curr.val);
            }
        }

        return res;
    }

    /**
     * DFS.
     *
     * @param root the root node of the tree
     * @return the right side view of the list
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root != null) {
            if (depth >= res.size()) { res.add(root.val); }
            dfs(root.right, depth+1, res);
            dfs(root.left, depth+1, res);
        }
    }
}
