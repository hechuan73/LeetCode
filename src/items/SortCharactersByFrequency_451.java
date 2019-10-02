package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class SortCharactersByFrequency_451 {

    public String frequencySort(String s) {
        // use array use store the letter frequencies.
        int[] frequencies = new int[128];
        for (int i = 0; i < s.length(); i++) { frequencies[s.charAt(i)]++; }

        // use bucket sort. the index of bucket is frequency of each letter.
        List<Character> [] bucket = new List[s.length()+1];
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] != 0) {
                if (bucket[frequencies[i]] == null) { bucket[frequencies[i]] = new ArrayList<>(); }
                bucket[frequencies[i]].add((char) i);
            }
        }

        // combine the characters for result.
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (Character cha : bucket[i]) {
                    // in JDK 11, can be replace with "sb.append(String.valueOf(cha).repeat(i));"
                    // repeat the letter with frequency times.
                    for (int j = 0; j < i; j++) {
                        sb.append(cha);
                    }
                }
            }
        }

        return sb.toString();
    }
}
