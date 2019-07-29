package items;

public class SetMatrixZeros_73 {
    /**
     * 1. If cell[i][j] == 0, set the cell[i][0] = 0 and cell[0][j] = 0.
     * 2. Because annotation element of the first row and col is cell[0][0], so we need another variable to record the
     *    first column(use cell[0][0] to record first row).
     * 3. When we finish annotating, we should set other raws and columns to zero instead of the first raw and column,
     *    to avoid the impact to others.
     * @param matrix input matrix
     */
    public static void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        // record the first column whether should be zero.
        boolean firstRolZero = false;

        for (int i = 0; i < row; i++) {

            // record the first column
            if (matrix[i][0] == 0) firstRolZero = true;

            // start from the second column
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // delay the setting of the first row and column to avoid the other rows and columns.

        // start from the second row and column
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        // set the first row to zero.
        if (matrix[0][0] == 0) {
            for (int i = 1; i < col; i++) matrix[0][i] = 0;
        }

        // set the first column to zero.
        if (firstRolZero) {
            for (int i = 0; i < row; i++) matrix[i][0] = 0;
        }
    }
}
