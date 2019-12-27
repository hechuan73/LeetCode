package items;

import java.util.List;

/**
 * @author hechuan
 */
public class ReplaceWords_648 {

    /**
     * Simple trie method.
     *
     * @param dict input dict list
     * @param sentence input sentence
     * @return the sentence which has been replaced words.
     */
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        TrieNode curr;

        // build the trie tree
        int index = 0;
        for (String str : dict) {
            curr = root;
            for (int i = 0; i < str.length(); i++) {
                index = str.charAt(i)-'a';
                if (curr.children[index] == null) { curr.children[index] = new TrieNode(); }
                curr = curr.children[index];
            }
            curr.isEnding = true;
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder pattern;
        String[] words = sentence.split(" ");
        // search each words in trie.
        for (String word : words) {
            curr = root;
            pattern = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                pattern.append(word.charAt(i));
                index = word.charAt(i)-'a';
                // whether next character is in trie or the it is ending character.
                if (curr.children[index] == null || curr.children[index].isEnding) { break; }
                curr = curr.children[index];
            }

            sb.append(curr.children[index] == null ? word : pattern.toString());
            sb.append(" ");
        }

        return sb.substring(0, sb.length()-1);
    }
}
