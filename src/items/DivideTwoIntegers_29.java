package items;

public class DivideTwoIntegers_29 {
    public static int divide(int dividend, int divisor) {
        boolean sign = (dividend < 0) ^ (divisor < 0);
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        long dividend1 = Math.abs((long)dividend);
        long divisor1 = Math.abs((long)divisor);

        int result = fastDivide(dividend1, divisor1);
        return sign ? -result : result;
    }

    private static int fastDivide(long dividend, long divisor) {
        if (divisor > dividend) return 0;

        int multiple = 1;
        long sum = divisor;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        while (sum + sum <= dividend) {
            sum += sum;
            multiple += multiple;
        }

        return multiple + fastDivide(dividend - sum, divisor);
    }
}
