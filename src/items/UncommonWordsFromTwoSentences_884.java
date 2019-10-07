package items;

import java.util.*;

public class UncommonWordsFromTwoSentences_884 {

    public String[] uncommonFromSentences1(String A, String B) {
        Map<String, Integer> counter = new HashMap<>(A.length()+B.length());

        for (String string : A.split(" ")) {
            counter.put(string, counter.getOrDefault(string, 0)+1);
        }

        for (String string : B.split(" ")) {
            counter.put(string, counter.getOrDefault(string, 0)+1);
        }

        List<String> res = new ArrayList<>();
        for (String key : counter.keySet()) {
            if (counter.get(key) == 1) {
                res.add(key);
            }
        }
        // foreach is too slow.
        // counter.forEach((k, v) -> { if (v == 1) { res.add(k); } });

        return res.toArray(new String[0]);
    }

    public String[] uncommonFromSentences2(String A, String B) {
        Set<String> distinct = new HashSet<>(), com = new HashSet<>();
        for (String s : (A + " " + B).split(" ")) {
            if (com.contains(s) || !distinct.add(s)) { distinct.remove(s); com.add(s); }
        }
        return distinct.toArray(new String[0]);
    }
}
