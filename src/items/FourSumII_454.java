package items;

import java.util.HashMap;
import java.util.Map;

public class FourSumII_454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumCounter = new HashMap<>(A.length);

        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                sumCounter.put(sum, sumCounter.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                res += sumCounter.getOrDefault(-sum, 0);
            }
        }
        return res;
    }
}
