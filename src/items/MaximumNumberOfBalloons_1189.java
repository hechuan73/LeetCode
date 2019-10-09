package items;

/**
 * @author hechuan
 */
public class MaximumNumberOfBalloons_1189 {

    public int maxNumberOfBalloons(String text) {
        int[] counter = new int[26];
        for (char c : text.toCharArray()) {
            counter[c-'a']++;
        }

        // balloon
        // for 'b' - 1
        int res = counter[1];
        // for 'a' - 0
        res = Math.min(counter[0], res);
        // for 'l' - 11
        res = Math.min(counter['l'-'a']/2, res);
        // for 'o' - 14
        res = Math.min(counter['o'-'a']/2, res);
        // for 'n' - 13
        res = Math.min(counter['n'-'a'], res);

        return res;
    }

}
