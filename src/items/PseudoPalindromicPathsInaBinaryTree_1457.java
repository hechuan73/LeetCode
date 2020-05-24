package items;

/**
 * 这里使用数组来缓存之前的数字，由于回文字符串，所有字符要么全为偶数个，要么只有奇数个。所以可以考虑用异或累积的方式来进行判断是否为回文，提升效
 * 率。
 *
 * @author hechuan
 */
public class PseudoPalindromicPathsInaBinaryTree_1457 {

    private int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root != null) {
            dfs(root, new int[10]);
        }
        return res;
    }

    private void dfs(TreeNode root, int[] counter) {
        counter[root.val]++;
        if (root.left == null && root.right == null) {
            res += checkPalindrome(counter) ? 1 : 0;
        }

        if (root.left != null) { dfs(root.left, counter); }
        if (root.right != null) { dfs(root.right, counter); }
        counter[root.val]--;
    }

    private boolean checkPalindrome(int[] counter) {
        int odd = 0;
        for (int count : counter) {
            if ((count & 1) == 1) {
                if (odd == 1) { return false; }
                odd++;
            }
        }

        return true;
    }
}
