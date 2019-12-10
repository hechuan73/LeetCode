package items;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hechuan
 */
public class ShortEncodingOfWords_820 {
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        TrieNode curr;
        int index, res = 0;
        Map<TrieNode, Integer> wordIndexes = new HashMap<>(words.length);
        // build trie tree.
        for (int i = 0; i < words.length; i++) {
            curr = root;
            for (int j = words[i].length()-1; j >=0 ; j--) {
                index = words[i].charAt(j)-'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            wordIndexes.put(curr, i);
        }

        for (Map.Entry<TrieNode, Integer> entry : wordIndexes.entrySet()) {
            // just count the leaf node, can simplify with add property to count node's child count in TrieNode class.
            if (entry.getKey().isEnding && !hasChild(entry.getKey())) { res += words[entry.getValue()].length() + 1; }
        }
        return res;
    }

    private boolean hasChild(TrieNode root) {
        for (TrieNode child : root.children) {
            if (child != null) { return true; }
        }
        return false;
    }
}
