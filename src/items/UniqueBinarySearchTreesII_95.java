package items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hechuan
 */
public class UniqueBinarySearchTreesII_95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) { return Collections.EMPTY_LIST; }
        return backtracking(1, n);
    }

    private List<TreeNode> backtracking(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        TreeNode root;
        List<TreeNode> leftChildren, rightChildren;
        for (int i = start; i <= end; i++) {
            leftChildren = backtracking(start, i-1);
            rightChildren = backtracking(i+1, end);
            for (TreeNode left : leftChildren) {
                for (TreeNode right : rightChildren) {
                    root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
