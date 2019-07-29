package items;

import java.util.*;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> chaCountToStrings = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!chaCountToStrings.containsKey(key)) chaCountToStrings.put(key, new ArrayList<>());
            chaCountToStrings.get(key).add(s);
        }
        return new ArrayList<>(chaCountToStrings.values());
    }


    public List<List<String>> groupAnagrams2(String[] strs) {

        Map<String, List<String>> chaCountToStrings = new HashMap<>();
        int[] chaCounts = new int[26];

        for (String s : strs) {
            Arrays.fill(chaCounts, 0);
            for (char c : s.toCharArray()) {
                chaCounts[c-'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int chaCount : chaCounts) {
                sb.append("#").append(chaCount);
            }

            String key = sb.toString();
            if (!chaCountToStrings.containsKey(key)) chaCountToStrings.put(key, new ArrayList<>());
            chaCountToStrings.get(key).add(s);
        }

        return new ArrayList<>(chaCountToStrings.values());
    }
}
