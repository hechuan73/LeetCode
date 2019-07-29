package items;

public class ReverseInteger_7 {
    public static int reverse(int x) {
        long number = x, sum = 0;

        while (number != 0) {
            sum = sum * 10 + number % 10;
            number /= 10;
        }

        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)
            return 0;

        return (int) sum;

    }
}
