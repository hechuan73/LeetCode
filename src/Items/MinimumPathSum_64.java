package Items;

public class MinimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        int row, col;
        if ((row = grid.length) == 0) return 0;
        col = grid[0].length;

        for (int i = 1; i < col; i++) grid[0][i] += grid[0][i-1];

        for (int i = 1; i < row; i++) grid[i][0] += grid[i-1][0];

        for (int i = 1; i < row; i++)
            for (int j = 1; j < col; j++)
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);

        return grid[row-1][col-1];
    }
}
