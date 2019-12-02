package items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hechuan
 */
public class MostFrequentSubtreeSum_508 {

    private int maxCount = Integer.MIN_VALUE;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumTimes = new HashMap<>();
        dfs(root, sumTimes);
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumTimes.entrySet()) {
            if (entry.getValue() == maxCount) {
                res.add(entry.getKey());
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        // use "return res.stream().mapToInt(i->i).toArray();" is to slow.
        return ans;
    }

    private int dfs(TreeNode root, Map<Integer, Integer> sumTimes) {
        if (root == null) { return 0; }
        int left = dfs(root.left, sumTimes);
        int right = dfs(root.right, sumTimes);
        int sum = root.val + left + right;
        sumTimes.put(sum, sumTimes.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(maxCount, sumTimes.get(sum));
        return sum;
    }
}
