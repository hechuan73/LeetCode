package items;

public class ValidPerfectSquare_367 {

    /**
     * Using the Newton method.
     * the iterate formula is: Xn+1 = (Xn + n/Xn)/2.
     *
     * @param num input number
     * @return whether the input number is a square number.
     */
    public boolean isPerfectSquare1(int num) {
        long value = num;
        while (value * value > num) {
            value = (value + num/value) >> 1;
        }

        return value * value == num;
    }

    /**
     * Using the binary search.
     *
     * @param num input number
     * @return whether the input number is a square number.
     */
    public  boolean isPerfectSquare2(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = low + ((high-low)>>1);
            long tmp = mid * mid;
            if (tmp == num) {
                return true; }
            else if (tmp > num) {
                high = (int) mid-1; }
            else {
                low = (int) mid+1; }
        }

        return false;
    }
}
