package items;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) { return res; }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelNumbers = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelNumbers.add(node.val);
                if (node.left != null) { queue.add(node.left); }
                if (node.right != null) { queue.add(node.right); }
            }

            res.add(levelNumbers);
        }

        return res;
    }
}
