package items;

/**
 * @author hechuan
 */
public class CountServersThatCommunicate_1267 {

    /**
     * Solve with two steeps:
     * 1. count all server, and each row and column servers.
     * 2. if grid[i][j] == 1, but this row and this column just has the only one server, which means it is not
     *    connected, so remove it from the result.
     *
     * @param grid input grid
     * @return the connected servers
     */
    public int countServers(int[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) { return res; }

        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        for (int i = 0; i < grid.length-1; i += 2) {
            for (int j = 0; j < grid[0].length-1; j++) {
                if (grid[i][j] == 1) {
                    res++;
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        for (int i = 0; i < grid.length-1; i += 2) {
            for (int j = 0; j < grid[0].length-1; j++) {
                if (grid[i][j] == 1) {
                    if (rows[i] == 1 && cols[j] == 1) { res--; }
                }
            }
        }

        return res;
    }
}
