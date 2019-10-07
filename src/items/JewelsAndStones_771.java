package items;

public class JewelsAndStones_771 {

    public int numJewelsInStones(String J, String S) {
        int[] jewels = new int[128];

        for (int i = 0; i < J.length(); i++) { jewels[J.charAt(i)] = 1; }

        int res = 0;
        for (int i = 0; i < S.length(); i++) {
            if (jewels[S.charAt(i)] == 1) { res++; }
        }

        return res;
    }
}
