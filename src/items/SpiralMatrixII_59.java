package items;

public class SpiralMatrixII_59 {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int r1 = 0, r2 = n-1;
        int c1 = 0, c2 = n-1;
        int num = 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) res[r1][i] = num++;
            for (int i = r1+1; i <= r2 ; i++) res[i][c2] = num++;

            if (r1 < r2 && c1 < c2) {
                for (int i = c2-1; i >= c1 ; i--) res[r2][i] = num++;
                for (int i = r2-1; i > r1 ; i--) res[i][c1] = num++;
            }

            r1++;
            r2--;
            c1++;
            c2--;
        }

        return res;
    }
}
