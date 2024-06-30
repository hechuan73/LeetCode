package items;

/**
 * @author hechuan
 */
public class NumberOfGoodLeafNodesPairs_1530 {

    private int res = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }

    private int[] dfs(TreeNode root, int distance) {
        // 先求当前节点的子节点中，每一个距离的对应的子节点数目，在返回时统一加一，返回到上一层父节点中
        int[] counter = new int[distance+1];
        if (null == root) { return counter; }

        // 统计字节点中，距离当前节点不同距离的节点数目
        int[] left = dfs(root.left, distance);
        int[] right = dfs(root.right, distance);

        // 叶子结点
        if (null == root.left && null == root.right) {
            // 表示距离其父节点距离为1的节点数目为1
            counter[1] = 1;
            return counter;
        }

        // 在每一层统计满足距离要求的节点对数
        for (int i = 0; i < counter.length; i++) {
            for (int j = 0; j < counter.length; j++) {
                if (i + j <= distance) {
                    res += (left[i] * right[j]);
                }
            }
        }

        // 准备返回，路径距离统一加一，返回到父节点中
        for (int i = 0; i < counter.length-1; i++) {
            counter[i + 1] = (left[i] + right[i]);
        }

        return counter;
    }
}
