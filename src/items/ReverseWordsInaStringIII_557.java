package items;

/**
 * @author hechuan
 */
public class ReverseWordsInaStringIII_557 {

    /**
     * Simple brute force method.
     *
     * @param s input string
     * @return the reversed words
     */
    public String reverseWords1(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                for (int j = i-1; j >= start; j--) {
                    sb.append(chars[j]);
                }
                sb.append(' ');
                start = i+1;
            }
        }

        for (int i = chars.length-1; i >= start; i--) {
            sb.append(chars[i]);
        }

        return sb.reverse().toString();
    }

    /**
     * Reversed the char array of the string in place.
     *
     * @param s input string
     * @return the reversed words
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();

        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i-1);
                start = i+1;
            }
        }

        reverse(chars, start, chars.length-1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        char tmp;
        while (start < end) {
            tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }
}
