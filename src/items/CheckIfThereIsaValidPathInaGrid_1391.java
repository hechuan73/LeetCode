package items;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hechuan
 */
public class CheckIfThereIsaValidPathInaGrid_1391 {

    /**
     * Simple solution with BFS.
     *
     * @param grid input grid
     * @return whether there is a valid path from (0, 0) to (m, n)
     */
    public boolean hasValidPath(int[][] grid) {
        int[][][] dirs = {
                {{0, -1}, {0, 1}},
                {{-1, 0}, {1, 0}},
                {{0, -1}, {1, 0}},
                {{0, 1}, {1, 0}},
                {{0, -1}, {-1, 0}},
                {{0, 1}, {-1, 0}}
        };

        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new ArrayDeque<>();
        visited[0][0] = true;
        queue.offer(new int[]{0, 0});
        int[] curr;
        int nx, ny;
        while (!queue.isEmpty()) {
            if (visited[row-1][col-1]) {return true; }

            curr = queue.poll();
            for (int[] dir : dirs[grid[curr[0]][curr[1]] - 1]) {
                nx = curr[0] + dir[0];
                ny = curr[1] + dir[1];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col || visited[nx][ny]) { continue; }
                for (int[] nDir : dirs[grid[nx][ny] - 1]) {
                    if (nx + nDir[0] == curr[0] && ny + nDir[1] == curr[1]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return visited[row-1][col-1];
    }
}
