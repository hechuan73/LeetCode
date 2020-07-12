package items;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hechuan
 */
public class NumberOfSubstringsWithOnlyOnes_1513 {

    public int numSub(String s) {
        long res = 0;
        Map<Long, Long> lenCounter = new HashMap<>();
        long start = 0;
        char[] chars = s.toCharArray();
        boolean rangeStart = false;
        long len;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                if (!rangeStart) {
                    start = i;
                    rangeStart = true;
                }
            }
            else {
                if (rangeStart) {
                    len = i-start;
                    lenCounter.put(len, lenCounter.getOrDefault(len, 0L)+1);
                    rangeStart = false;
                }
            }
        }

        if (rangeStart) { lenCounter.put(chars.length-start, lenCounter.getOrDefault(chars.length-start, 0L)+1); }

        for (Map.Entry<Long, Long> entry : lenCounter.entrySet()) {
            res += entry.getValue() * ((1+entry.getKey())*entry.getKey()/2);
        }

        return (int) (res % 1000000007);
    }
}
