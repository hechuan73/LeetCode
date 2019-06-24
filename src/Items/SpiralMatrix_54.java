package Items;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    /**
     * We traverse the matrix with clockwise from outer to inner.
     *
     * Note: If the num of row or column is odd number，there will be duplicate numbers with 4 loop of 4 edges, it
     *       just need 2 loop, so we use "if" statement to remove the duplicates when the r1 == r2 or c1 == c2.
     *
     * @param matrix input matrix
     * @return result list
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;

        int r1 = 0, r2 = matrix.length-1;
        int c1 = 0, c2 = matrix[0].length-1;

        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) res.add(matrix[r1][i]);
            for (int i = r1+1; i <= r2 ; i++) res.add(matrix[i][c2]);

            if (r1 < r2 && c1 < c2) {
                for (int i = c2-1; i >= c1 ; i--) res.add(matrix[r2][i]);
                for (int i = r2-1; i > r1 ; i--) res.add(matrix[i][c1]);
            }

            r1++;
            r2--;
            c1++;
            c2--;
        }

        return res;
    }
}
