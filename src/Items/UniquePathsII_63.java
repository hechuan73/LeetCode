package Items;

/**
 * Approach 1: The total paths are the sum of right's paths and down's paths. So we can iterate them as method
 *  'uniquePaths1'. However, if the m or n is very big, the process is time-consuming.
 *
 * Approach 2:
 *     1. If the first cell obstacleGrid[0,0] or the last cell obstacleGrid[maxRow,maxCol] contains 1, there is no path
 *     so return 0. Otherwise, if obstacleGrid[0,0] has a 0 originally we set it to 1 and move ahead.
 *     2. Iterate the first row. If a cell originally contains a 1, this means the current cell has an obstacle and
 *     shouldn't contribute to any path. Hence, set the value of that cell to 0. Otherwise, set it to the value of
 *     previous cell i.e. obstacleGrid[i,j] = obstacleGrid[i,j-1].
 *     3. Iterate the first column. If a cell originally contains a 1, this means the current cell has an obstacle and
 *     shouldn't contribute to any path. Hence, set the value of that cell to 0. Otherwise, set it to the value of
 *     previous cell i.e. obstacleGrid[i,j] = obstacleGrid[i-1,j].
 *     4. Now, iterate through the array starting from cell obstacleGrid[1,1]. If a cell originally doesn't contain any
 *     obstacle then the number of ways of reaching that cell would be the sum of number of ways of reaching the cell
 *     above it and number of ways of reaching the cell to the left of it:
 *          obstacleGrid[i,j] = obstacleGrid[i-1,j] + obstacleGrid[i,j-1]
 *     5. If a cell contains an obstacle set it to 0 and continue. This is done to make sure it doesn't contribute to
 *     any other path.
 */
public class UniquePathsII_63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (n == 0) return 0;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;

        obstacleGrid[0][0] = 1;

        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0) ? obstacleGrid[0][i-1] : 0;
        }

        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0) ? obstacleGrid[i-1][0] : 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 0 ? obstacleGrid[i-1][j] + obstacleGrid[i][j-1] : 0;
            }
        }

        return obstacleGrid[m-1][n-1];
    }

    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (n == 0) return 0;

        return uniquePaths1(obstacleGrid, 0, 0, m, n);
        //if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;

    }

    public static int uniquePaths1(int[][] obstacleGrid, int row, int col, int maxRow, int maxCol) {
        if (row < maxRow && col < maxCol) {
            if (obstacleGrid[row][col] == 1) return 0;
            if (row == maxRow-1 && col == maxCol-1 && obstacleGrid[row][col] == 0) return 1;

            int downCount = uniquePaths1(obstacleGrid,row+1, col, maxRow, maxCol);
            int rightCount = uniquePaths1(obstacleGrid, row, col+1, maxRow, maxCol);

            return downCount + rightCount;
        }
        else return 0;

    }
}
