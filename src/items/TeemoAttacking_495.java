package items;

/**
 * @author hechuan
 */
public class TeemoAttacking_495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) { return 0; }
        int res = duration;

        for (int i = 1; i < timeSeries.length; i++) {
            res += Math.min(duration, timeSeries[i] - timeSeries[i-1]);
        }
        return res;
    }
}
