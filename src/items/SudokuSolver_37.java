package items;

/**
 * @author hechuan
 */
public class SudokuSolver_37 {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) { return; }
        backtracking(board);
    }

    private boolean backtracking(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (backtracking(board)) { return true; }
                            else { board[i][j] = '.'; }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char cha) {
        int blockRow, blockCol;
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == cha) { return false; }
            if (board[row][i] != '.' && board[row][i] == cha) { return false; }
            // 这里是单循环，而且需要定位到给定的row, col附近的block，所以计算block行列的公式不再是：
            // blockRow = row / 3 * 3 + i / 3, blockCol = row % 3 * 3 + i % 3;
            blockRow = row / 3 * 3 + i / 3;
            blockCol = col / 3 * 3 + i % 3;
            if (board[blockRow][blockCol] != '.' && board[blockRow][blockCol] == cha) { return false; }
        }

        return true;
    }
}
