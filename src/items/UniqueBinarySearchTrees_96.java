package items;

/**
 * @author hechuan
 */
public class UniqueBinarySearchTrees_96 {

    /**
     * DP solution:
     *
     * 对于输入的节点数n，我们可以以 1~n 中的任意一个节点作为根节点以构建不同的BST。当确定某个节点i为根节点时，节点[1, i-1]则为该BST的左子树，节
     * 点[i+1, n]则为该BST的右子树。则以节点i为根节点的BST的总数为以节点[1, i-1]为左子树，以节点[i+1, n]为左子树的总数的乘积。
     *
     * 设f(i, n)表示以节点为根节点，总结点数为n的BST的总数；g(n)表示节点总数为n时，BST的总数。则可得以下公式：
     * 1. g(n) = f(1, n) + f(2, n) + ... + f(n-1, n) + f(n, n)
     * 2. f(i, n) = g(i-1) * g(n-i) (1 <= i <= n)
     *
     * 推导可得：
     * 1. g(n) = g(0)*g(n) + g(1)*g(n-1) + ... + g(n-1)*g(1) + g(n)*g(0)
     * 2. g(0) = g(1) = 1
     *
     * @param n number of nodes
     * @return the number of BST constructed by n nodes
     */
    public int numTrees(int n) {
        int[] g = new int[n+1];
        g[0] = g[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                g[i] += g[j-1] * g[i-j];
            }
        }
        return g[n];
    }
}
