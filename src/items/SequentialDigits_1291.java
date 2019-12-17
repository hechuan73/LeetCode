package items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hechuan
 */
public class SequentialDigits_1291 {

    /**
     * The all available numbers are easy to enumerate, so we can calculate all numbers.
     *
     * @param low low value
     * @param high high value
     * @return the sequential digits
     */
    public List<Integer> sequentialDigits1(int low, int high) {

        int[] allNums = {12,23,34,45,56,67,78,89,
                         123,234,345,456,567,678,789,
                         1234,2345,3456,4567,5678,6789,
                         12345,23456,34567,45678,56789,
                         123456,234567,345678,456789,
                         1234567,2345678,3456789,
                         12345678,23456789,
                         123456789};

        List<Integer> res = new ArrayList<>();
        int n = allNums.length;
        for (int num : allNums) {
            if (num < low) { continue; }
            if (num > high) { break; }
            res.add(num);
        }
        return res;
    }

    /**
     * DFS method. Calculate all available numbers with different digits which start with specific digit, and then
     * Calculate other available numbers with different digits which start with the next digit. For example,
     * if the first digit is 1, we will consider numbers 12, 123, 1234 ...
     * and then the first digit will be 2, we will also consider numbers 23, 234, 2345 ...
     *
     * So the elements in the result list is not ordered, we need sor them.
     *
     * @param low low value
     * @param high high value
     * @return the sequential digits
     */
    public List<Integer> sequentialDigits2(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int next, n, tmp;
        for (int digit = 1; digit < 9; digit++) {
            next = digit;
            n = next;
            while (n <= high && next < 10) {
                if (n >= low) { res.add(n); }

                tmp = 10 * n + ++next;
                if (tmp > n) { n = tmp; }
                // for number overflow
                else { break; }
            }
        }
        Collections.sort(res);
        return res;
    }

    /**
     * Simple backtracking method with number digits range, such as low = 10, high = 200, the available number digits
     * range is 2 and 3. So we backtrack to search qualified number in these range.
     *
     * @param low low value
     * @param high high value
     * @return the sequential digits
     */
    public List<Integer> sequentialDigits3(int low, int high) {
        // the digits of low value, such as 10 -> 2, 100 -> 3
        int lowDigit = (int) Math.floor(Math.log10(low) + 1);
        // the digits of low value
        int highDigit = (int) Math.floor(Math.log10(high) + 1);

        List<Integer> res = new ArrayList<>();
        // traverse the available digits of result value
        for (int i = lowDigit; i <= highDigit; i++) {
            // the range of first digit is [1, 9-i+1]
            for (int j = 1; j <= 9-i+1; j++) {
                backTracking(low, high, i, j, res, new StringBuilder());
            }

        }

        return res;
    }

    private void backTracking(int low, int high, int digitCount, int beginDigit, List<Integer> res, StringBuilder sb) {
        if (sb.length() > digitCount) { return;}
        else if (sb.length() == digitCount) {
            int value = Integer.parseInt(sb.toString());
            if (value >= low && value <= high) {
                res.add(value);
            }
            return;
        }

        // since the current digit need to be one more than the last one, which means digits[i] = digits[i-1]+1, so we
        // dont need to traverse all digits in 1 ~ 9.
        sb.append(beginDigit);
        backTracking(low, high, digitCount, beginDigit+1, res, sb);
    }
}
