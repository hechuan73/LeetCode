package items;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hechuan
 */
public class VerbalArithmeticPuzzle_1307 {

    /**
     * 常规的做法一般是:
     * 1. 解析输入的字符串，以确定待编码的字符集；
     * 2. 回溯的方式进行编码；
     * 3. 编码完成后，比较左右两侧，以确定等式是否成立。
     *
     * 解法中：
     * 1. 利用额外数组来记录输入的首字符集，以在编码时避开用0编码它们；
     * 2. 利用额外数组来计算每一位的10的幂次和，分担一部分最后比较的计算工作；
     * 3. 回溯时，通过将每一位与第2步中计算的10的幂次和相乘，来更新左右两侧的diff，由于不清楚正负，所以统一用加法计算。
     *
     * @param words input words array
     * @param result result string
     * @return whether the equation can be resolved
     */
    public boolean isSolvable(String[] words, String result) {
        // init power array of 10.
        int[] power = new int[] {1, 10, 100, 1000, 10000, 100000, 1000000};
        // store the inputting character.
        Set<Character> chaSet = new HashSet<>();
        // in ASCLL table A~Z is 65 ~ 90.
        int[] charSum = new int[91];
        // record whether the leading character can be decoded as 0.
        boolean[] nonLeadingZero = new boolean[91];

        char index;
        int len;
        // traverse the left side words list.
        for (String str : words) {
            len = str.length();
            for (int i = 0; i < len; i++) {
                index = str.charAt(i);
                // when the string.length = 1, the leading character can be decoded as 0;
                // when the string.length > 1, the leading character can not be decoded as 0.
                if (i == 0 && len > 1) { nonLeadingZero[index] = true; }
                chaSet.add(index);
                // charSum is calculated by units.
                charSum[index] += power[len-i-1];
            }
        }

        // traverse the result list.
        len = result.length();
        for (int i = 0; i < len; i++) {
            index = result.charAt(i);
            if (i == 0 && len > 1) { nonLeadingZero[index] = true; }
            chaSet.add(index);
            charSum[index] -= power[len-i-1];
        }

        // record whether the number 0~9 has been used.
        boolean[] used = new boolean[10];
        // use char array to speed instead of char set.
        char[] chaArr = new char[chaSet.size()];
        int i = 0;
        for (Character cha : chaSet) { chaArr[i++] = cha; }

        return backtracking(chaArr, charSum, 0, 0, nonLeadingZero, used);

    }

    private boolean backtracking(char[] chars, int[] charSum, int start, int diff, boolean[] nonLeadingZero, boolean[] used) {
        if (start == chars.length) { return diff == 0; }

        char cha;
        boolean nonLeadZero;
        for (int i = 0; i <= 9; i++) {
            cha = chars[start];
            // if nonLeadZero is true, the 0 can encode the character;
            // if nonLeadZero is false, the 0 cant encode the character;
            nonLeadZero = i > 0 || !nonLeadingZero[cha];
            if (!used[i] && nonLeadZero) {
                used[i] = true;
                if (backtracking(chars, charSum, start+1, charSum[cha] * i + diff, nonLeadingZero, used)) { return true; }
                used[i] = false;
            }

        }
        return false;
    }
}
