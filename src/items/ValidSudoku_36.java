package items;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hechuan
 */
public class ValidSudoku_36 {

    /**
     * The important thing is how to record the visiting of each row, column and block.
     * Here we use a hash set and each element of row, column and block is unique.
     *
     * @param board input board
     * @return whether the Sudoku is valid
     */
    public boolean isValidSudoku1(char[][] board) {
        Set<String> visited = new HashSet<>();
        char cha;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                cha = board[i][j];
                if (cha != '.') {
                    if (!visited.add(cha + "in row" + i) ||
                            !visited.add(cha + "in col" + j) ||
                            !visited.add(cha + "in block" + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        int index, rowBlock, colBlock;
        boolean[] rowCheck, colCheck, blockCheck;
        for (int row = 0; row < board.length; row++) {
            rowCheck = new boolean[9];
            colCheck = new boolean[9];
            blockCheck = new boolean[9];
            for (int col = 0; col < board[0].length; col++) {
                // check the row
                if (board[row][col] != '.') {
                    index = board[row][col]-'1';
                    if (rowCheck[index]) { return false; }
                    rowCheck[index] = true;
                }

                // check the column
                if (board[col][row] != '.') {
                    index = board[col][row]-'1';
                    if (colCheck[index]) { return false; }
                    colCheck[index] = true;
                }

                // check the block
                // 这里是行列双层循环，所以计算block的公式如下：
                rowBlock = row / 3 * 3 + col / 3;
                colBlock = row % 3 * 3 + col % 3;
                if (board[rowBlock][colBlock] != '.') {
                    index = board[rowBlock][colBlock]-'1';
                    if (blockCheck[index]) { return false; }
                    blockCheck[index] = true;
                }
            }
        }

        return true;
    }
}
