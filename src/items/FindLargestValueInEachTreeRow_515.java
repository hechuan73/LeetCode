package items;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hechuan
 */
public class FindLargestValueInEachTreeRow_515 {

    /**
     * BFS/Level Traversal
     *
     * @param root root node of the tree
     * @return the largest nodes of each row
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) { return res; }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int rowSize, max;
        TreeNode curr;
        while (!queue.isEmpty()) {
            rowSize = queue.size();
            max = Integer.MIN_VALUE;
            while (rowSize-- > 0) {
                curr = queue.poll();
                max = Math.max(curr.val, max);
                if (curr.left != null) { queue.offer(curr.left); }
                if (curr.right != null) { queue.offer(curr.right); }
            }
            res.add(max);
        }

        return res;
    }
}
