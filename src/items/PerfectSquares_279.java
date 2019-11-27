package items;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hechuan
 */
public class PerfectSquares_279 {

    /**
     * DFS: Simple recursive dynamic programming with cache.
     *
     * @param n input n
     * @return the minimum number's squares which sum to n.
     */
    public int numSquares1(int n) {
        int[] cache = new int[n+1];
        return dfs(n, cache);
    }

    private int dfs(int n, int[] cache) {
        if (cache[n] != 0) { return cache[n]; }

        int val = (int) Math.sqrt(n);
        if (val * val == n) { return cache[n] = 1; }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i < n; i++) {
            // n = i*i + (n-i*i), so we calculate the dfs(n-i*i) and then plus 1, 1 means the number i
            res = Math.min(res, dfs(n-i*i, cache) + 1);
        }

        return res;
    }

    /**
     * Improved iterative dynamic programming with cache.
     *
     * @param n input n
     * @return the minimum number's squares which sum to n.
     */
    public int numSquares2(int n) {
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            // init the maximum value, for number i, the maximum is i = i*1.
            dp[i] = i;
            for (int j = 1; j * j <= i ; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }

        return dp[n];
    }

    /**
     * BFS: 将问题转化成图，使用BFS来解决。
     *
     * 问题建模：将整个问题变成一个图论问题：
     * 1. 从n到0，每个数字代表一个节点；
     * 2. 如果两个数 x 到 y 相差一个完全平方数，则连接一条边,我们就得到了一个无权图；
     * 3. 原来的问题就转化为，在这个无权图中找出从 n 到 0 的最短路径，所以需要 BFS 来完成；
     *
     * 4. 有人可能会通过贪心算法来处理该问题，但这是错误的，因为我们要找的是最少个数，贪心可能找的是最简单的树，而数量可能会很多。
     * 5. 为什么使用广度搜索得到的step一定是最少需要的平方个数：
     *    因为广度执行的steps，代表着每一条路径都向前走了steps。如果已经找到目的地了，就意味着最少有一条路径向前走steps就可以走到目的地，而其
     *    他路径的不会少于这个steps，所以这个steps一定是最短路径。
     *
     * @param n input n
     * @return the minimum number's squares which sum to n.
     */
    public int numSquares3(int n) {
        boolean[] visited = new boolean[n+1];
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(new GraphNode(n, 0));

        GraphNode curr;
        int num, step, m;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            num = curr.val;
            step = curr.step;

            for (int i = 0; i * i <= num ; i++) {
                m = num - i*i;
                if (m == 0) { return step+1; }

                if (!visited[m]) {
                    queue.add(new GraphNode(m, step+1));
                    visited[m] = true;
                }
            }
        }

        return -1;
    }

    class GraphNode {
        int val;
        int step;

        public GraphNode(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }


    /**
     * Mathematical method:
     *     Lagrange's four-square theorem, also known as Bachet's conjecture, states that every natural number can be
     *     represented as the sum of four integer squares:
     *         p = a^2 + b^2 + c^2 + d^2.
     *
     *     Besides, Adrien-Marie Legendre completed the theorem in 1797–8 with his three-square theorem, by proving that
     *     a positive integer can be expressed as the sum of within three squares if and only if it is not of the form:
     *     4^k * (8m+7) for integers k and m.
     *
     *     So only when n = 4^k * (8m+7), it can be expressed as the sum of within four squares.
     *
     * @param n input n
     * @return the minimum number's squares which sum to n.
     */
    public int numSquares4(int n) {

        // case 1
        int m = (int) Math.sqrt(n);
        if (m * m == n) { return 1; }

        // case 2
        for (int i = 1; i * i <= n; i++) {
            m = (int) Math.sqrt(n - i*i);
            if (m * m + i * i == n) { return 2; }
        }

        // case 4
        while (n % 4 == 0) { n /= 4; }
        if (n % 8 == 7) { return 4; }

        // case 3
        return 3;
    }
}
