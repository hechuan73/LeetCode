package items;

/**
 * @author hechuan
 */
public class MinimumNumberOfStepsToMakeTwoStringsAnagram_1347 {

    public int minSteps(String s, String t) {
        int[] chas = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chas[s.charAt(i) - 'a']++;
            chas[t.charAt(i) - 'a']--;
        }

        int res = 0;
        for (int cha : chas) { if (cha > 0) { res += cha; } }

        return res;
    }
}
