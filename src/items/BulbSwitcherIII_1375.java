package items;

public class BulbSwitcherIII_1375 {

    /**
     * Count the maximum bulb which has been turing on as 'right', and if the index of turing on is one less than the
     * right, it means all bulbs in the left of the maximum index bulb have been turned on.
     * 
     * @param light the light order array
     * @return the times of all bulbs turning blue
     */
    public int numTimesAllBlue(int[] light) {
        int res = 0, right = 0;
        for (int i = 0; i < light.length; i++) {
            right = Math.max(right, light[i]);
            if (right == i+1) { res++; }
        }

        return res;
    }
}
