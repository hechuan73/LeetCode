package Items;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        hasPathSum(root, sum, 0, new ArrayList<>(), result);
        return result;
    }


    public static void hasPathSum(TreeNode root, int sum, int curSum, List<Integer> current, List<List<Integer>> result) {
        if (root != null) {
            current.add(root.val);
            if (curSum+root.val == sum) {
                // 1. currentSum == sum;
                // 2. root.left == null && root.right == null.
                if (root.left == null && root.right == null) result.add(new ArrayList<>(current));
            }

            hasPathSum(root.left, sum, curSum+root.val, current, result);
            hasPathSum(root.right, sum, curSum+root.val, current, result);
            current.remove(current.size()-1);
        }
    }
}
