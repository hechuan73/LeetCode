package items;

import java.util.*;

/**
 * @author hechuan
 */
public class NAryTreeLevelOrderTraversal_429 {

    /**
     * BFS.
     * @param root root node
     * @return each level nodes
     */
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) { return res; }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int levelLen;
        List<Integer> currLevel;
        Node curr;
        while (!queue.isEmpty()) {
            levelLen = queue.size();
            currLevel = new ArrayList<>();
            while (levelLen-- > 0) {
                curr = queue.poll();
                currLevel.add(curr.val);
                if (curr.children != null && !curr.children.isEmpty()) { queue.addAll(curr.children); }
            }
            res.add(currLevel);
        }

        return res;
    }

    /**
     * DFS.
     * @param root root node
     * @return each level nodes
     */
    public List<List<Integer>> levelOrder(Node root) {
        return dfs(root, 0, new ArrayList<>());
    }

    private List<List<Integer>> dfs(Node root, int level, List<List<Integer>> res) {
        if (root == null) { return res; }

        boolean newLevel = level >= res.size();
        List<Integer> levelNums = newLevel ? new ArrayList<>() : res.get(level);
        levelNums.add(root.val);
        if (newLevel) { res.add(levelNums); }
        for (Node node : root.children) {
            dfs(node, level+1, res);
        }

        return res;
    }
}

