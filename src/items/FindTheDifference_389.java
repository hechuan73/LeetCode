package items;

/**
 * @author hechuan
 */
public class FindTheDifference_389 {

    /**
     * Using Xor.
     *
     * @param s input string
     * @param t input string
     * @return the added letter.
     */
    public char findTheDifference1(String s, String t) {
        char cha = t.charAt(t.length()-1);

        for (int i = 0; i < s.length(); i++) {
            cha ^= s.charAt(i);
            cha ^= t.charAt(i);
        }

        return cha;
    }

    /**
     * Using addition and subtraction.
     *
     * @param s input string
     * @param t input string
     * @return the added letter.
     */
    public static char findTheDifference2(String s, String t) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum -= s.charAt(i)-'a';
            sum += t.charAt(i)-'a';
        }

        sum += t.charAt(t.length()-1);

        return (char) sum;
    }

    /**
     * Using hash table: array index is key, array element is value.
     *
     * @param s input string
     * @param t input string
     * @return the added letter.
     */
    public char findTheDifference3(String s, String t) {
        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }

        counter[t.charAt(t.length()-1)-'a']--;

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) { return (char) ('a'+i); }
        }

        return ' ';
    }

}
