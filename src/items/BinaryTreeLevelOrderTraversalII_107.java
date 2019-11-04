package items;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hechuan
 */
public class BinaryTreeLevelOrderTraversalII_107 {


    /**
     * BFS traverse
     *
     * @param root the root node of the tree
     * @return the nodes with level order from bottom to up
     */
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> levelNodes = new LinkedList<TreeNode>();

        if (root == null) { return res; }
        levelNodes.offer(root);

        List<Integer> subList;
        TreeNode curr;
        int levelNodesNum;
        while (!levelNodes.isEmpty()) {
            levelNodesNum = levelNodes.size();
            subList = new LinkedList<>();
            for (int i = 0; i < levelNodesNum; i++) {
                curr = levelNodes.poll();
                if (curr.left != null) { levelNodes.offer(curr.left); }
                if (curr.right != null) { levelNodes.offer(curr.right); }
                subList.add(curr.val);
            }
            res.add(0, subList);
        }

        return res;
    }


    /**
     * DFS traverse
     *
     * @param root the root node of the tree
     * @return the nodes with level order from bottom to up
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) { return; }
        if (level >= res.size()) { res.add(0, new LinkedList<>());}

        dfs(res, root.left, level+1);
        dfs(res, root.right, level+1);
        res.get(res.size()-level-1).add(root.val);
    }
}
