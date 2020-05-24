package items;

import java.util.HashMap;
import java.util.Map;

public class SuperEggDrop_887 {

    /**
     * 经典的DP问题：
     *
     * 思路和算法：
     * 我们可以考虑使用动态规划来做这道题，状态可以表示成 (K, N)，其中 K 为鸡蛋数，N 为楼层数。当我们从第 X 楼扔鸡蛋的时候：
     * 1. 如果鸡蛋不碎，那么状态变成 (K, N-X)，即我们鸡蛋的数目不变，但答案只可能在上方的 N-X 层楼了。也就是说，我们把原问题缩小成了一个规模
     *    为 (K, N-X) 的子问题；
     * 2. 如果鸡蛋碎了，那么状态变成 (K-1, X-1)，即我们少了一个鸡蛋，但我们知道答案只可能在第 X 楼下方的 X-1 层楼中了。也就是说，我们把原问
     *    题缩小成了一个规模为 (K-1, X-1) 的子问题。
     *
     * 这样一来，我们定义 dp(K, N) 为在状态 (K, N) 下最少需要的步数。根据以上分析我们可以列出状态转移方程：
     * dp(K, N) = 1 +  Math.min(Math.max(dp(K-1, X-1), dp(K, N-X))) 1 <= X <= N
     *
     * 我们观察到 dp(K, N) 是一个关于 N 的单调递增函数，也就是说在鸡蛋数 K 固定的情况下，楼层数 N 越多，需要的步数一定不会变少。在上述的状态
     * 转移方程中，第一项 T1(X) = dp(K-1, X-1)是一个随 X 的增加而单调递增的函数，第二项 T2(X) = dp(K, N-X) 是一个随着 X 的增加而单调递
     * 减的函数。
     *
     * 如果这两个函数都是连续函数，那么我们只需要找出这两个函数的交点，在交点处就能保证这两个函数的最大值最小。但在本题中，T1(X) 和 T2(x) 都是
     * 离散函数，也就是说，X 的值只能取 1, 2, 3... 等。在这种情况下，我们需要找到最大的满足 T1(X) < T2(X) 的X0，以及最小的满足
     * T1(X) > T2(X)的X1，对应到两者的函数图中，就是离这两个函数（想象中的）交点左右两侧最近的整数。
     *
     * 我们只需要比较在 X0和 X1处两个函数的最大值，取一个最小的作为 X 即可。在数学上，我们可以证明出 X0和 X1相差 1，这也是比较显然的，因为它
     * 们正好夹住了那个想象中的交点，并且相距尽可能地近。因此我们就可以使用二分查找的方法找出 X0，再得到 X1：
     * 1. 我们在所有满足条件的 X 上进行二分查找。对于状态 (K, N) 而言，X 即为 [1, N] 中的任一整数；
     * 2. 在二分查找的过程中，假设当前这一步我们查找到了 X_mid，如果 T1(X_mid) > T2(X_mid)，那么真正的 X0 一定在 X_mid的左侧，否则真正的
     * X0在 X_mid的右侧。
     *
     * 二分查找的写法因人而异，本质上我们就是需要找到最大的满足 T1(X) < T2(X) 的X0，根据 X_mid进行二分边界的调整。在得到了 X0后，我们可以知
     * 道 X1 即为 X0 + 1，此时我们只需要比较 max(T1(X0), T2(X0))和 max(T1(X1), T2(X1)), ，取较小的那个对应的位置作为 X 即可。
     *
     * 这样一来，对于给定的状态 (K, N)，我们只需要 O(logN) 的时间，通过二分查找就能得到最优的那个 X，因此时间复杂度从 O(KN^2)降低至
     * O(KN*logN)，可以通过本题。
     *
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/super-egg-drop/solution/ji-dan-diao-luo-by-leetcode-solution-2/
     *
     * @param K input K
     * @param N input N
     * @return solution
     */
    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    /**
     * 如果使用二维dp数组，会更省时，但是更消耗空间
     */
    Map<Integer, Integer> cache = new HashMap<>();
    private int dp(int k, int n) {
        // cache的key，做乘法是为了保证不冲突。如果使用二维dp数组，会更省时，但是更消耗空间
        int key = n*100 + k;
        if (!cache.containsKey(n*100 + k)) {
            int res = 0;
            if (n == 0) { return 0; }
            else if (k == 1) { res = k; }
            else {
                int low = 1, high = n, mid;
                int t1, t2;
                while (low+1 < high) {
                    mid = low + ((high-low)>>1);
                    // 鸡蛋碎了
                    t1 = dp(k-1, mid-1);
                    // 鸡蛋没碎
                    t2 = dp(k, n-mid);
                    if (t1 < t2) {
                        low = mid;
                    }
                    else if (t1 > t2){
                        high = mid;
                    }
                    else {
                        low = high = mid;
                    }
                }

                res = 1 + Math.min(Math.max(dp(k-1, low-1), dp(k, n-low)),
                        Math.max(dp(k-1, high-1), dp(k, n-high)));
            }

            cache.put(key, res);
        }

        return cache.get(key);
    }
}
