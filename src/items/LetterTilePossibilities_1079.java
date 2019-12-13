package items;

import java.util.Arrays;

/**
 * @author hechuan
 */
public class LetterTilePossibilities_1079 {

    /**
     * Simple dfs solution for problem: for n letters, each letter[i] can repeats counts[i] times at most, calculate the
     * number of permutations.
     *
     * @param tiles input letters array
     * @return the number of permutations
     */
    public int numTilePossibilities1(String tiles) {
        int[] counts = new int[26];
        for (char c : tiles.toCharArray()) { counts[c-'a']++; }
        return dfs(counts);
    }

    private int dfs(int[] counts) {
        int sum = 0;

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                sum++;
                counts[i]--;
                sum += dfs(counts);
                counts[i]++;
            }
        }

        return sum;
    }

    private int res;

    /**
     * Simple backtracking in sorted array for permutation with repeated number.
     *
     * @param tiles input letters array
     * @return the number of permutations
     */
    public int numTilePossibilities(String tiles) {
        res = 0;
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, 0, new boolean[chars.length]);
        return res;
    }

    private void backtracking(char[] chars, int length, boolean[] visited) {
        if (length == chars.length) { return;}

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) { continue; }
            if (i > 0 && chars[i] == chars[i-1] && !visited[i-1]) { continue; }
            res++;
            visited[i] = true;
            backtracking(chars, length+1, visited);
            visited[i] = false;
        }
    }
}
