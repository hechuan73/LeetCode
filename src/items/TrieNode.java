package items;

/**
 * @author hechuan
 */
public class TrieNode {

    public TrieNode[] children;
    public boolean isEnding;

    public TrieNode() {
        int charsetSize = 26;
        children = new TrieNode[charsetSize];
    }
}
