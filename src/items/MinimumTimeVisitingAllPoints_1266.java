package items;

/**
 * @author hechuan
 */
public class MinimumTimeVisitingAllPoints_1266 {

    public int minTimeToVisitAllPoints(int[][] points) {

        int res = 0, x, y;
        int[] prev = points[0];
        for (int i = 1; i < points.length; i++) {
            x = Math.abs(points[i][0] - prev[0]);
            y = Math.abs(points[i][1] - prev[1]);
            res += Math.max(x, y);
            prev = points[i];
        }

        return res;
    }
}
