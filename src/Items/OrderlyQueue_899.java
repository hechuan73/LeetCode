package Items;

import java.util.Arrays;

public class OrderlyQueue_899 {

    public String orderlyQueue(String S, int K) {

        if (K == 1) {
            String ans = S;
            for (int i = 0; i < S.length(); i++) {
                String T = S.substring(i) + S.substring(0, i); // if S = "cba", when i=0, T = cba; i=1, T=bac; i=2, T = acb.
                if (T.compareTo(ans) < 0) ans = T;
            }

            return ans;
        }
        else {
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

    }
}
