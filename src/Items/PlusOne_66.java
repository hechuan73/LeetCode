package Items;

public class PlusOne_66 {

    /**
     * Three case:
     *     1. [1, 2, 3] -> [1, 2, 4].
     *     2. [1, 2, 9] -> [1, 3, 0].
     *     3. [9, 9, 9] -> [1, 0, 0, 0].
     *
     * Use "count" to record how many digits of '9' in the input array.
     *
     * @param digits input array
     * @return output array
     */
    public static int[] plusOne(int[] digits) {

        int count=0;

        for (int i = digits.length-1; i >= 0; i--) {
            if ((digits[i] + 1) % 10 == 0) count++;
            else break;
        }

        if (count == 0) {
            digits[digits.length-1] += 1;
            return digits;
        }
        else {
            int[] result;
            if (count == digits.length) {
                result = new int[digits.length + 1];
                result[0] = 1;
            }
            else {
                result = new int[digits.length];
                System.arraycopy(digits, 0, result, 0, digits.length-count-1);
                result[digits.length-count-1] = digits[digits.length-count-1] + 1;
            }
            return result;
        }
    }
}
