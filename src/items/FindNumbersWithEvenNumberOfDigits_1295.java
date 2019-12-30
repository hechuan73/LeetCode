package items;

/**
 * @author hechuan
 */
public class FindNumbersWithEvenNumberOfDigits_1295 {

    /**
     * Simple solution.
     *
     * @param nums input array
     * @return the amount of the element contains even digits in the array.
     */
    public int findNumbers1(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if (containEvenDigits(num)) { res++; }
        }
        return res;
    }

    private boolean containEvenDigits(int num) {
        boolean res = true;

        while (num != 0) {
            res = !res;
            num /= 10;
        }

        return res;
    }

    /**
     * Simple solution with transferring to string and get its length.
     *
     * @param nums input array
     * @return the amount of the element contains even digits in the array.
     */
    public int findNumbers2(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if (Integer.toString(num).length() % 2 == 0) { res++; }
        }
        return res;
    }

    /**
     * Tricky solution. 1 <= nums[i] <= 10^5.
     *
     * @param nums input array
     * @return the amount of the element contains even digits in the array.
     */
    public int findNumbers3(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if ((num >= 10 && num < 100) || (num >= 1000 && num < 10000)) { res++; }
        }
        return res;
    }
}
