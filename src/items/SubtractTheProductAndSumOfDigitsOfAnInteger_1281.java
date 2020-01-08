package items;

/**
 * @author hechuan
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger_1281 {

    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        int digit;
        while (n != 0) {
            digit = n % 10;
            product *= digit;
            sum += digit;
            n /= 10;
        }

        return product-sum;
    }
}
