package items;

public class NQueensII_52 {

    private int res = 0;

    /**
     * Solution with backtracking.
     *
     * @param n input n
     * @return the placements of queens
     */
    public int totalNQueens(int n) {
        if (n == 0) { return res; }

        // indexes[i] = j， 表示第i行第j列放置了棋子
        int[] indexes = new int[n];
        backtracking(n, 0, indexes);

        return res;
    }

    private void backtracking(int n, int row, int[] indexes) {
        if (row == n) {
            res++;
            return;
        }

        for (int col = 0; col < n; col++) {
            // 第row行第col列是否能够放置棋子
            if (isOk(row, col, indexes)) {
                // 将棋子放置在第row行第col列
                indexes[row] = col;
                // 考察下一行
                backtracking(n, row+1, indexes);
            }
        }
    }

    private boolean isOk(int row, int col, int[] indexes) {
        int leftUp = col-1, rightUp = col+1;
        for (int i = row-1; i >= 0; i--) {
            // 第i行第col列是否放置列棋子
            if (indexes[i] == col) { return false; }
            // 左对角线上是否放置了棋子
            if (leftUp >= 0 && indexes[i] == leftUp--) { return false; }
            // 右对角线上是否放置了棋子
            if (rightUp < indexes.length && indexes[i] == rightUp++) { return false; }
        }

        return true;
    }
}
