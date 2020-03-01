package items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hechuan
 */
public class RankTeamsByVotes_1366 {

    public String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();
        char cha;
        int length = votes[0].length();
        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; i < length; i++) {
                cha = votes[i].charAt(j);
                map.putIfAbsent(cha, new int[length]);
                map.get(cha)[j]++;
            }
        }

        List<Character> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> {
            for (int i = 0; i < length; i++) {
                if (map.get(a)[i] != map.get(b)[i]) {
                    return map.get(b)[i]- map.get(a)[i];
                }
            }

            // sort by nature/alphabetical order
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for (Character ch : keys) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
