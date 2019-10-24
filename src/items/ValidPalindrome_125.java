package items;

/**
 * @author hechuan
 */
public class ValidPalindrome_125 {

    public boolean isPalindrome1(String s) {
        char[] chars = new char[128];

        for (int i = 0; i < 10; i++) {
            // (1+i) can be replaced by other character in the range 128;
            chars['0'+i] = (char) (1+i);
        }

        for (int i = 0; i < 26; i++) {
            // (11+i) can be replaced by other character in the range 128;
            chars['a'+i] = chars['A'+i] = (char) (11+i);
        }

        int start = 0, end = s.length()-1;
        while (start < end) {
            if (chars[s.charAt(start)] == 0) { start++; }
            else if (chars[s.charAt(end)] == 0) { end--; }
            else if (chars[s.charAt(start++)] != chars[s.charAt(start--)]) { return false; }
        }

        return true;
    }

    public boolean isPalindrome2(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0, right = s.length()-1;

        while (left < right) {
            if (Character.isLetterOrDigit(chars[left])) {
                if (Character.isLetterOrDigit(chars[right])) {
                    if (chars[left] != chars[right]) { return false; }
                    else {
                        left++;
                        right--;
                    }
                }
                else { right--; }
            }
            else { left++; }
        }

        return true;
    }
}
