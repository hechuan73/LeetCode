package items;

/**
 * @author hechuan
 */
public class PlayWithChips_1217 {

    /**
     * even indexes move to even indexes cost 0, and odd indexes move to odd indexes cost 0, so we can move all even
     * indexes to one index, and move all odd indexes to the other index, and these two indexes are adjacent. So finally
     * we just need to choose move all even indexes number to the adjacent odd index, or move all odd indexes number to
     * the adjacent even index. The intrinsic question is compare the amount of odd and even numbers.
     *
     * @param chips input chips array
     * @return minimum cost to move chips
     */
    public int minCostToMoveChips(int[] chips) {
        int odd = 0, even = 0;

        for (int chip : chips) {
            if ((chip & 1) == 0) { even++; }
            else { odd++; }
        }

        return Math.min(odd, even);
    }
}
