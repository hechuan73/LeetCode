package items;

/**
 * @author hechuan
 */
public class IslandPerimeter_463 {

    /**
     * As we know, an island cell bring 4 edges, and if it has a neighbor, it will reduce 2edges. So we can count the
     * island cells and its neighbors, and calculate the perimeter with "4 * island - 2 * neighbor".
     *
     * Note that: when we count the neighbors of the island cells, we just need to count the downward and rightward cell
     * to avoid duplicate cells.
     *
     * @param grid input array
     * @return the perimeter of the island.
     */
    public int islandPerimeter(int[][] grid) {
        int island = 0, neighbor = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    island++;
                    // count the downward and rightward cell to avoid duplicate cells.
                    if (i < grid.length-1 && grid[i+1][j] == 1) { neighbor++; }
                    if (j < grid[i].length-1 && grid[i][j+1] == 1) { neighbor++; }
                }
            }
        }

        return 4 * island - 2 * neighbor;
    }
}
