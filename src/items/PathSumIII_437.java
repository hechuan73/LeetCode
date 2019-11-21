package items;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hechuan
 */
public class PathSumIII_437 {


    /**
     * 双重递归：
     *
     * 由于可以从任意节点开始，并在任意节点结束，看起来比较复杂，换个角度思考：
     * 1. 找出以根节点为开始，任意节点可作为结束，且路径上的节点和为 sum 的路径的个数;
     * 2. 在解决了以根节点开始的所有路径后，就要找以根节点的左孩子和右孩子开始的所有路径，三个节点构成了一个递归结构；
     * 3. 递归查找。
     *
     * Time Complexity：O(nlogn) worst:O(n2)
     * Space Complexity: O(n) (recursion)
     *
     * @param root input root
     * @param sum target sum
     * @return the path which sum to target sum
     */
    public int pathSum1(TreeNode root, int sum) {
        if (root == null) { return 0; }
        return pathSumFrom(root, sum) + pathSum1(root.left, sum) + pathSum1(root.right, sum);
    }

    private int pathSumFrom(TreeNode curr, int sum) {
        if (curr == null) { return 0; }
        return (curr.val == sum ? 1 : 0)
                + pathSumFrom(curr.left, sum - curr.val) + pathSumFrom(curr.right, sum-curr.val);
    }


    /**
     * 一重递归：
     *
     * 第一种做法很明显效率不够高，存在大量重复计算
     * 所以第二种做法，采取了类似于数组的前n项和的思路，比如sum[4] == sum[1]，那么1到4之间的和肯定为0
     *
     * 1. 对于树的话，采取DFS加回溯，每次访问到一个节点，把该节点加入到当前的pathSum中。
     * 2. 然后判断是否存在一个之前的前n项和，其值等于pathSum与sum之差
     * 3. 如果有，就说明现在的前n项和，减去之前的前n项和，等于sum，那么也就是说这两个点之间的路径和就是sum，即存在一条路径。
     * 4. 最后要注意的是，记得回溯，把路径和弹出去。因为这里map记录的是：从根节点到当前节点的路径上，以根节点为起点，长为key的子序列的数量。遍
     *    历左节点的时候，把到左节点的路径给统计进去了。再遍历到右节点的时候，根节点到之前遍历的左节点的路径不满足上面的要求了，所以要把对应添加
     *    的那个计数给去掉。
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param root input root
     * @param sum target sum
     * @return the path which sum to target sum
     */
    public int pathSum2(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, sum, 0, map);
    }

    private int dfs(TreeNode root, int sum, int pathSum, Map<Integer, Integer> map) {
        if (root == null) { return 0; }

        pathSum += root.val;
        int res = map.getOrDefault(pathSum-sum, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        res += dfs(root.left, sum, pathSum, map) + dfs(root.right, sum, pathSum, map);
        map.put(pathSum, map.get(pathSum) - 1);

        return res;
    }
}
