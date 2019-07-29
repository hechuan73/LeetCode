package items;

public class RotateImage_48 {
    /**
     * Approach 1: We can see the regularity of the four elements, the indexes of the elements are:
     * (i, j) -> (j, n-i-1) -> (n-i-1, n-j-1) -> (n-j-1, i) -> (i, j)
     *
     * Approach 2: Firstly reverse the whole matrix, then reverse it by the positive diagonal.
     * 1 2 3      7 8 9      7 4 1
     * 4 5 6  ->  4 5 6  ->  8 5 2
     * 7 8 9      1 2 3      9 6 3
     *
     * @param matrix input matrix
     */
    public static void rotate(int[][] matrix) {
        int tmp;
        int n = matrix.length; // row = column
        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-i-1; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }

}
