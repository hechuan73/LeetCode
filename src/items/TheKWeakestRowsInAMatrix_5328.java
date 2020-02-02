package items;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hechuan
 */
public class TheKWeakestRowsInAMatrix_5328 {

    /**
     * Simple solution with sort.
     *
     * @param mat input matrix
     * @param k limit number
     * @return the k weakest rows
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] rowSoldiers = new int[mat.length][2];
        int count;
        for (int i = 0; i < mat.length; i++) {
            count = 0;
            for (int j = 0; j < mat[0].length; j++) { if (mat[i][j] == 1) { count++; } }
            rowSoldiers[i] = new int[] {count, i};
        }

        Comparator<int[]> comparator = (int[] o1, int[] o2) -> {
            if (o1[0] < o2[0]) { return -1;}
            else if (o1[0] > o2[0]) { return 1; }
            else {
                if (o1[1] < o2[1]) { return -1; }
                else { return 1; }
            }
        };

        Arrays.sort(rowSoldiers, comparator);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) { res[i] = rowSoldiers[i][1]; }

        return res;
    }
}
