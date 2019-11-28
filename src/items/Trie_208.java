package items;

/**
 * @author hechuan
 */
public class Trie_208 {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie_208() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode p = root;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i)-'a';
            if (p.children[index] == null) { p.children[index] = new TrieNode(); }
            p = p.children[index];
        }
        p.isEnding = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode p = root;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i)-'a';
            if (p.children[index] == null) { return false; }
            p = p.children[index];
        }

        return p.isEnding;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        int index;
        for (int i = 0; i < prefix.length(); i++) {
            index = prefix.charAt(i)-'a';
            if (p.children[index] == null) { return false; }
            p = p.children[index];
        }

        return true;
    }
}
