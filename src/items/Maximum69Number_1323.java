package items;

/**
 * @author hechuan
 */
public class Maximum69Number_1323 {

    /**
     * Simple solution with string.
     *
     * @param num input number
     * @return maximum 69 number
     */
    public int maximum69Number1 (int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }

    /**
     * Optimised mathematical solution.
     *
     * @param num input number
     * @return maximum 69 number
     */
    public int maximum69Number2 (int num) {
        int number = num;
        int firstSix = -1;
        for (int i = 0; number > 0; i++) {
            if (number % 10 == 6) { firstSix = i; }
            number /= 10;
        }

        return num +  3 * (int) Math.pow(10, firstSix);
    }
}
