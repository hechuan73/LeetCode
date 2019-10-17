package items;

/**
 * @author hechuan
 */
public class SplitaStringInBalancedStrings_1221 {

    public int balancedStringSplit(String s) {
        int res = 0, sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) == 'L' ? -1 : 1;
            if (sum == 0) { res++; }
        }

        return res;
    }
}
