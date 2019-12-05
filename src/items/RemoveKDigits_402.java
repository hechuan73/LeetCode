package items;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hechuan
 */
public class RemoveKDigits_402 {

    /**
     * 为了使删除k位之后的数值最小，贪心法基本思路：由最高位开始，比较低一位数字，如高位大，移除，若高位小，则向右移一位继续比较两个数字，直到高
     * 位大于低位则移除，循环k次。如：
     * 4556847594546移除5位：
     * 455647594546 -> 45547594546 -> 4547594546 -> 447594546 -> 44594546
     *
     * 但是有几种特殊情况需要考虑到：
     * 1. 可能number的高位一直比低位小，如：123456789，k = 5。遍历完后我们就要冲后往前倒着删除。
     * 2. 最后得到的数字可能前几位为0，需要特殊处理。如"000123"。
     *
     * 为了这k次循环每次我们都从头开始，比较高位和低位，以找到高位比低位的情况，这里我们采用Stack，类比寻找next greater number的思路，这里
     * 用寻找next smaller number从左往右，遍历一遍数字即可。如果k依然大于0，我们再从后往前倒着删除余下的k位。由于Stack是先进后出，最后为了
     * 拼成字符串结果，出栈后我们还需要再reverse一遍，为了减小这部分开销，我们考虑采用Deque来解决这个问题。
     *
     * @param num input number
     * @param k digits to remove
     * @return the minimum value after removing k digits.
     */
    public static String removeKdigits(String num, int k) {
        if (k == num.length()) { return "0"; }
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();
        int i = 0;
        // traverse the string number
        while (i < num.length()) {
            // if the high digits is bigger than the low digits, drop the high digits.
            while (k > 0 && !deque.isEmpty() && deque.peek() > num.charAt(i)) {
                deque.pop();
                k--;
            }

            deque.push(num.charAt(i));
            i++;
        }

        // for case num = "123456789", k=5
        while (k > 0) {
            deque.pop();
            k--;
        }

        // construct the string
        while (!deque.isEmpty()) { sb.append(deque.removeLast()); }

        // remove the first several 0 digits
        while (sb.length() > 1 && sb.charAt(0) == '0') { sb.deleteCharAt(0); }

        return sb.toString();
    }
}
