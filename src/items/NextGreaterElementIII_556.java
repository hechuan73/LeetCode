package items;

import java.util.Arrays;

public class NextGreaterElementIII_556 {

    /**
     * At first, lets look at the edge cases:
     *     1. If all digits sorted in descending order, then output is always “Not Possible”. For example, 4321.
     *     2. If all digits are sorted in ascending order, then we need to swap last two digits. For example, 1234.
     *     3. For other cases, we need to process the number from rightmost side (why? because we need to find the
     *        smallest of all greater numbers)
     * The algorithm mainly contains three steps:
     *     1. Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller
     *        than the previously traversed digit. For example, if the input number is “534976”, we stop at 4 because 4
     *        is smaller than next digit 9. If we do not find such a digit, then output is “Not Possible”.
     *     2. Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’. For “534976″,
     *        the right side of 4 contains “976”. The smallest digit greater than 4 is 6.
     *     3. Swap the above found two digits, we get 536974 in above example.
     *     4. Now sort all digits from position next to ‘d’ to the end of number. The number that we get after sorting
     *        is the output. For above example, we sort digits in bold 536974. We get “536479” which is the next greater
     *        number for input 534976.
     *
     * @param n input n
     * @return the next greater element
     */
    public int nextGreaterElement(int n) {
        if (n / 10 == 0) { return -1; }
        String string = String.valueOf(n);
        char[] chars = string.toCharArray();

        int i, j;
        for (i = chars.length - 1; i > 0; i--) {
            // find the digit which is smaller than its right side digit.
            if (chars[i-1] < chars[i]) { break; }
        }

        if (i == 0) {return -1;}

        // find the smallest greater digit in the right side and swap them.
        for (j = chars.length - 1; j >= i; j--) {
            if (chars[j] > chars[i-1]) {
                char tmp = chars[j];
                chars[j] = chars[i-1];
                chars[i-1] = tmp;
                break;
            }
        }

        // resort the digits in the right side of the left swap digit.
        Arrays.sort(chars, i, chars.length);
        // check whether the value is overflow.
        long res = Long.parseLong(new String(chars));
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }
}
