package items;

public class PowerOfTwo_231 {


    /**
     * Power of 2 means only one bit of n is '1', so use the trick n&(n-1)==0 to judge whether it is the case.
     *
     * @param n input number
     * @return whether the number is the power of two.
     */
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n&(n-1))==0);
    }

    public static boolean isPowerOfTwo2 (int n) {
        if (n == 0) {return false;}
        if (n == 1) {return true;}
        while (true) {
            int quotient = n / 2;
            int remainder = n % 2;
            if (quotient != 1) {
                if (remainder == 0) { n = quotient;}
                else { return false;}
            }
            else { return remainder == 0;}
        }
    }
}
