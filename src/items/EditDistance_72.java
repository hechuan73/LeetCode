package items;

/**
 * @author hechuan
 */
public class EditDistance_72 {

    /**
     * 设 f(i, j)表示字符串1中前 i 个字符能够与字符串2前 j 个字符匹配的开销。所以在计算f(i, j)时有两种情况：
     * 1. word1.charAt(i) == word2.charAt(j)：
     *      f(i+1, j+1) = f(i, j)
     * 2. word1.charAt(i) != word2.charAt(j)：
     *    word1 insert cost: f(i+1, j)
     *    Word1 delete cost：f(i, j+1)
     *    word1 replace cost: f(i, j)
     *
     *    f(i+1, j+1) = Min(insert, delete, replace) + 1
     *
     *
     * @param word1 input string1
     * @param word2 input string2
     * @return the minimum edit distance
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] cost = new int[m+1][n+1];

        // 初始化第一列
        for (int i = 0; i <= m; i++) {
            cost[i][0] = i;
        }

        // 初始化第一行
        for (int i = 0; i <= n; i++) {
            cost[0][i] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    cost[i+1][j+1] = cost[i][j];
                }
                else {
                    int insert = cost[i+1][j];
                    int delete = cost[i][j+1];
                    int replace = cost[i][j];
                    cost[i+1][j+1] = Math.min(insert, Math.min(delete, replace)) + 1;
                }
            }
        }

        return cost[m][n];
    }
}
