package items;

/**
 * @author hechuan
 */
public class ConvertIntegerToTheSumOfTwoNoZeroIntegers_1317 {

    public int[] getNoZeroIntegers(int n) {
        int[] res = new int[2];
        for (int i = 1; i <= n/2; i++) {
            if (!isContainZero(i) && !isContainZero(n-i)) {
                res[0] = i;
                res[1] = n-i;
                break;
            }
        }

        return res;
    }

    private boolean isContainZero(int num) {
        while (num != 0) {
            if (num % 10 == 0) { return true; }
            num /= 10;
        }

        return false;
    }
}
