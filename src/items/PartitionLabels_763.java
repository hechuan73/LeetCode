package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class PartitionLabels_763 {

    /**
     * Using a array to cache the last existence index of each character in string S.
     * Then traverse the characters in S, the maxIndex saving the max last existence of traversed characters, compare
     * the last existence of the current character to the maxIndex and update it greedily. When the maxIndex is equal to
     * the current index, partition the string and go on.
     *
     * @param S input string
     * @return the indexes of partition labels
     */
    public List<Integer> partitionLabels(String S) {
        int[] lastExistIndexes = new int[26];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            lastExistIndexes[S.charAt(i)-'a'] = i;
        }

        int maxIndex = 0, lastExistIndex, lastPivot = 0;
        for (int i = 0; i < S.length(); i++) {
            lastExistIndex = lastExistIndexes[S.charAt(i) - 'a'];
            maxIndex = Math.max(maxIndex, lastExistIndex);
            if (maxIndex == i) {
                res.add(i-lastPivot+1);
                lastPivot = i;
            }
        }

        return res;
    }
}
