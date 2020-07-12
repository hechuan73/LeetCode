package items;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author hechuan
 */
public class MakingFileNamesUnique_1487 {

    public String[] getFolderNames(String[] names) {
        HashSet<String> used = new HashSet<>();
        HashMap<String, Integer> suffixCache = new HashMap<>();
        String[] res = new String[names.length];
        int k;
        String suffix;
        for (int i = 0; i < names.length; i++) {
            if (used.contains(names[i])) {
                k = suffixCache.getOrDefault(names[i], 1);
                do {
                    suffix = "(" + ++k + ")";
                } while (used.contains(names[i] + suffix));
                res[i] = names[i] + suffix;
                suffixCache.put(names[i], k);
            }
            else {
                res[i] = names[i];
            }
            used.add(res[i]);
        }

        return res;
    }
}
