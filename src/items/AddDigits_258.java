package items;

/**
 * @author hechuan
 */
public class AddDigits_258 {

    /**
     * Of course we can traverse every digit of the number and sum them, but how to optimize?
     *
     * As we can see, a number,
     * 1. consisting of "ab", is equal to 10a+b in decimalism, which can be 9a+(a+b). Adding digits (a+b) is equal to
     *    (9a+(a+b)) % 9.
     * 2. consisting of "abc", is equal to 100a+10b+c in decimalism, which can be 9(11a+b)+(a+b+c). Adding digits
     *    (a+b+c) is equal to (9(11a+b)+(a+b+c)) % 9.
     *
     * Note: if a number can be divide with 9, such as 9, 99, the result is 0 which is incorrect. So we use (num-1) to
     *       guarantee the result is with 0~8, and then adding 1 is with 1~9, without 0.
     * Follow up: If the number is in X scale, we can calculate with the modulo (X-1).
     *
     * @param num input num
     * @return the result of adding digits
     */
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
