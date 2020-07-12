package items;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author hechuan
 */
public class AvoidFloodInTheCity_1488 {

    public int[] avoidFlood(int[] rains) {
        HashSet<Integer> lakeFull = new HashSet<>();
        List<Integer> rainDays = new ArrayList<>();
        List<Integer> fullLakes = new ArrayList<>();
        int needDry = 0;
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                rainDays.add(i);
            }
            else {
                if (lakeFull.contains(rains[i])) {
                    needDry++;
                    fullLakes.add(rains[i]);
                }
                else {
                    lakeFull.add(rains[i]);
                }
            }
        }

        if (needDry > rainDays.size()) { return new int[0]; }
        lakeFull = new HashSet<>();
        int[] res = new int[rains.length];

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] != 0) {
                if (lakeFull.contains(rains[i])) { return new int[0]; }
                else {
                    lakeFull.add(rains[i]);
                    res[i] = -1;
                }
            }
            else {
                res[i] = 1;
                for (int j = 0; j < fullLakes.size(); j++) {
                    if (lakeFull.contains(fullLakes.get(j))) {
                        res[i] = fullLakes.get(j);
                        fullLakes.remove(j);
                        break;
                    }
                }
                lakeFull.remove(res[i]);
            }
        }

        return res;
    }
}
