package items;

/**
 * @author hechuan
 */
public class TrieNode {

    public TrieNode[] children;
    public boolean isEnding;
    public int charsetSize = 26;

    public TrieNode() {
        children = new TrieNode[charsetSize];
    }
}
