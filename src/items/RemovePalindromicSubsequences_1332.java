package items;

/**
 * @author hechuan
 */
public class RemovePalindromicSubsequences_1332 {

    public int removePalindromeSub(String s) {
        if (s.length() == 0) { return 0; }
        int i = 0, j = s.length()-1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) { return 2; }
        }

        return 1;
    }
}
