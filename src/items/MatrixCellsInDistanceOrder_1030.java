package items;

import java.util.*;

/**
 * @author hechuan
 */
public class MatrixCellsInDistanceOrder_1030 {

    /**
     * Simple solution with nature order calculating.
     *
     * @param R rows of the matrix
     * @param C columns of the matrix
     * @param r0 horizontal axis of the given point
     * @param c0 vertical axis of the given point
     * @return the distance order of all cells
     */
    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        int[][] res = new int[R*C][2];
        List<int[][][]> data = new ArrayList<>();
        int[][][] tmp;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tmp = new int[1][1][3];
                tmp[0][0][0] = Math.abs(i-r0) + Math.abs(j-c0);
                tmp[0][0][1] = i;
                tmp[0][0][2] = j;
                data.add(tmp);
            }
        }

        data.sort(Comparator.comparingInt(o -> o[0][0][0]));
        int index = 0;
        for (int i = 0; i < R*C; i++) {
            res[i] = new int[] {data.get(index)[0][0][1], data.get(index++)[0][0][2]};
        }

        return res;
    }

    /**
     * Optimised solution with in-out calculating.
     *
     * @param R rows of the matrix
     * @param C columns of the matrix
     * @param r0 horizontal axis of the given point
     * @param c0 vertical axis of the given point
     * @return the distance order of all cells
     */
    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        int[][] res = new int[R*C][2];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        queue.add(new int[] {r0, c0});
        int[] point;
        int index = 0;
        while (!queue.isEmpty()) {
            point = queue.poll();
            if (point[0] < 0 || point[0] >= R || point[1] < 0 || point[1] >= C) { continue; }
            if (visited[point[0]][point[1]]) { continue; }
            res[index++] = point;
            visited[point[0]][point[1]] = true;
            queue.add(new int[] {point[0]-1, point[1]});
            queue.add(new int[] {point[0]+1, point[1]});
            queue.add(new int[] {point[0], point[1]-1});
            queue.add(new int[] {point[0], point[1]+1});
        }

        return res;
    }

    /**
     * Super solution with counting sort.
     *
     * @param R rows of the matrix
     * @param C columns of the matrix
     * @param r0 horizontal axis of the given point
     * @param c0 vertical axis of the given point
     * @return the distance order of all cells
     */
    public int[][] allCellsDistOrder3(int R, int C, int r0, int c0) {
        int[] counter = new int[R*C+1];
        int dist = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dist = Math.abs(i-r0) + Math.abs(j-c0);
                counter[dist+1]++;
            }
        }

        for (int i = 1; i < counter.length; i++) { counter[i] += counter[i-1]; }

        int[][] res = new int[R*C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dist = Math.abs(i-r0) + Math.abs(j-c0);
                res[counter[dist]] = new int[]{i, j};
                counter[dist]++;
            }
        }

        return res;
    }

}
