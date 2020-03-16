package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class LuckyNumbersInaMatrix_1380 {

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // 0 -> row, 1 -> column, 2 -> value;
        int[] values;
        boolean[] visited = new boolean[matrix[0].length];
        for (int[] ints : matrix) {
            values = new int[]{-1, -1, Integer.MAX_VALUE};
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] < values[2]) {
                    values[1] = j;
                    values[2] = ints[j];
                }
            }

            if (!visited[values[1]]) {
                int j = 0;
                for (; j < matrix.length; j++) {
                    if (j != values[0] && matrix[j][values[1]] > values[2]) {
                        break;
                    }
                }

                if (j == matrix.length) {
                    visited[values[1]] = true;
                    res.add(values[2]);
                }
            }

        }

        return res;
    }

}
