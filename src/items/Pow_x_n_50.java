package items;

public class Pow_x_n_50 {
    public static double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n/2;
        }

        if (n < 0) {
            x = 1/x;
            n = -n;
        }

        return (n % 2 == 0) ? myPow(x * x, n/2) : x*myPow(x * x, n/2);
    }

    public static double myPow2(double x, int n) {
        if (x == 0) return 0;
        long N = n;
        if (n == 0) return 1;
        else if (n < 0) {
            x = 1/x;
            N = -N;
        }

        double result = 1, tmp = x;

        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) result = result * tmp;
            tmp = tmp * tmp;
        }
        return result;
    }
}
