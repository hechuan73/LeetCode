package items;

import java.util.Arrays;

/**
 * @author hechuan
 */
public class LastMomentBeforeAllAntsFallOutOfaPlank_1503 {

    public int getLastMoment(int n, int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);
        if (right.length == 0) { return left[left.length-1]; }
        if (left.length == 0) { return n-right[0]; }

        return Math.max(n-right[0], left[left.length-1]);
    }
}
