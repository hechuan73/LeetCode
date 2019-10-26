package items;

/**
 * @author hechuan
 */
public class MaxConsecutiveOnes_485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, len = 0;
        for (int num : nums) {
            if (num != 1) {
                res = Math.max(res, len);
                len = 0;
            }
            else { len++; }
        }

        return Math.max(res, len);
    }
}
