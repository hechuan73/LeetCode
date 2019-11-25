package items;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hechuan
 */
public class MaximumDepthOfNAryTree_559 {

    /**
     * DFS.
     *
     * @param root the root of the N_Ary tree
     * @return the max depth
     */
    public int maxDepth1(Node root) {
        return dfs(root, 1, 0);
    }

    private int dfs(Node root, int depth, int res) {
        if (root != null) {
            res = Math.max(depth, res);
            for (Node child : root.children) { res = dfs(child, depth + 1, res); }
        }
        return res;
    }

    /**
     * BFS.
     *
     * @param root the root of the N_Ary tree
     * @return the max depth
     */
    public int maxDepth(Node root) {
        int res = 0;
        if (root == null) { return res; }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int levelSize;
        Node curr;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            while (levelSize-- > 0) {
                curr = queue.poll();
                if (curr.children != null && !curr.children.isEmpty()) { queue.addAll(curr.children); }
            }
            res++;
        }

        return res;
    }
}
