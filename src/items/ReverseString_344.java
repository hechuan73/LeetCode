package items;

/**
 * @author hechuan
 */
public class ReverseString_344 {

    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        char tmp;

        while (left < right) {
            tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}
