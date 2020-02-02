package items;

import java.util.*;

/**
 * @author hechuan
 */
public class MaximumProductOfSplittedBinaryTree_5330 {

    Map<TreeNode, Long> cache = new HashMap<>();

    /**
     * Simple method with two pass(1 dfs and 1 bfs).
     *
     * Note that:
     * 1. the product may be large (more than Integer.MAX_VALUE);
     * 2. the type of node.val is int not long, it can not use to cache the sum of its child nodes, so we use hash map.
     *
     * @param root root node of the tree
     * @return the maximum product of two subtrees
     */
    public int maxProduct1(TreeNode root) {
        return (int) (calculate(root, count(root)) % 1000000007);
    }

    private long calculate(TreeNode root, long total) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int levelSize;
        long product, sum, max = Long.MIN_VALUE;
        TreeNode node;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                node = queue.poll();
                if (node.left != null) {
                    sum = cache.get(node.left);
                    product = sum * (total-sum);
                    if (product > max) { max = product; }
                    queue.add(node.left);
                }
                if (node.right != null) {
                    sum = cache.get(node.right);
                    product = sum * (total-sum);
                    if (product > max) { max = product; }
                    queue.add(node.right);
                }

            }
        }

        return max;
    }

    private long count(TreeNode root) {
        long sum = 0;
        if (root != null) {
            sum += root.val;
            sum += count(root.left);
            sum += count(root.right);
        }
        cache.put(root, sum);
        return sum;
    }

    /**
     * Optimised method with one pass(1 dfs).
     *
     * Note that:
     * 1. the product may be large (more than Integer.MAX_VALUE);
     * 2. the type of node.val is int not long, it can not use to cache the sum of its child nodes, so we use hash set
     *    to cache the sum, and set can also filter the duplicate sum. Then we can calculate the product with the set
     *    element and total value directly instead of any extra pass.
     * 3. even if the type of node.val is int not long, and it will overfill when its value more than Integer.MAX_VALUE,
     *    usually it will be a negative value, but we can force cast it to long, and it will work.
     *
     * @param root root node of the tree
     * @return the maximum product of two subtrees
     */
    public int maxProduct(TreeNode root) {
        Set<Long> cache = new HashSet<>();
        long total = (long) dfs(root, cache);
        long res = Long.MIN_VALUE;
        for (Long sum : cache) {
            res = Math.max(res, sum*(total-sum));
        }

        return (int) (res % 1000000007);
    }

    private int dfs(TreeNode root, Set<Long> cache) {
        if (root == null) { return 0; }

        root.val += dfs(root.left, cache);
        root.val += dfs(root.right, cache);

        // even if its value may overfill and be negative, but we can force cast it to the long value and it will work.
        cache.add((long) root.val);
        return root.val;
    }
}
