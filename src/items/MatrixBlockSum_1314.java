package items;

/**
 * @author hechuan
 */
public class MatrixBlockSum_1314 {

    /**
     * Simple mathematical method.
     *
     * @param mat input matrix
     * @param K limit k
     * @return the matrix block sum
     */
    public int[][] matrixBlockSum1(int[][] mat, int K) {
        int[][] res = new int[mat.length][mat[0].length];

        // init the inputting matrix
        for (int i = 1; i < mat.length; i++) { mat[i][0] += mat[i-1][0]; }
        for (int i = 1; i < mat[0].length; i++) { mat[0][i] += mat[0][i-1]; }

        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                mat[i][j] += mat[i-1][j] + mat[i][j-1] - mat[i-1][j-1];
            }
        }

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = sum(mat, i-K, i+K, j-K, j+K);
            }
        }

        return res;
    }

    private int sum(int[][] mat, int startRow, int endRow, int startCol, int endCol) {
        if (startCol < 0) { startCol = 0; }
        if (startRow < 0) { startRow = 0; }
        if (endCol >= mat[0].length) { endCol = mat[0].length-1; }
        if (endRow >= mat.length) { endRow = mat.length-1; }

        if (startRow == 0 && startCol == 0) { return mat[endRow][endCol]; }
        else if (startRow == 0) { return mat[endRow][endCol] - mat[endRow][startCol-1]; }
        else if (startCol == 0) { return mat[endRow][endCol] - mat[startRow-1][endCol]; }
        else { return mat[endRow][endCol]-mat[endRow][startCol-1]-mat[startRow-1][endCol]+mat[startRow-1][startCol-1]; }
    }

    /**
     * Optimised mathematical method with extra space and place holder.
     *
     * @param mat input matrix
     * @param K limit k
     * @return the matrix block sum
     */
    public int[][] matrixBlockSum2(int[][] mat, int K) {
        int[][] rangeSum = new int[mat.length+1][mat[0].length+1];

        // init the inputting matrix
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                rangeSum[i+1][j+1] += rangeSum[i+1][j] + rangeSum[i][j+1] + mat[i][j] - rangeSum[i][j];
            }
        }

        int[][] res = new int[mat.length][mat[0].length];
        int r1, r2, c1, c2;
        for (int i = 0; i < rangeSum.length; i++) {
            for (int j = 0; j < rangeSum[0].length; j++) {
                r1 = Math.max(0, i-K);
                c1 = Math.max(0, j-K);
                r2 = Math.min(mat.length, i+K+1);
                c2 = Math.min(mat[0].length, j+K+1);
                res[i][j] = rangeSum[r2][c2] - rangeSum[r2][c1] - rangeSum[r1][c2] + rangeSum[r1][c1];
            }
        }

        return res;
    }
}
