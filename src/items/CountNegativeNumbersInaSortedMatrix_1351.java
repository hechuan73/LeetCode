package items;

/**
 * @author hechuan
 */
public class CountNegativeNumbersInaSortedMatrix_1351 {

    /**
     * Simple solution.
     *
     * @param grid input grid
     * @return the negatives
     */
    public int countNegatives1(int[][] grid) {
        int res = 0;

        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] < 0) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * Optimised solution.
     *
     * @param grid input grid
     * @return the negatives
     */
    public int countNegatives2(int[][] grid) {
        int res = 0;

        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] < 0) {
                    res += grid[0].length - j;
                    break;
                }
            }
        }
        return res;
    }
}