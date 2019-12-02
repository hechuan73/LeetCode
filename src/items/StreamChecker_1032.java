package items;

/**
 * @author hechuan
 */
public class StreamChecker_1032 {

    private TrieNode root;
    // 记录之前输入过的字符
    private StringBuilder sb;
    public StreamChecker_1032(String[] words) {
        root = new TrieNode();
        buildTrieTree(words);
        sb = new StringBuilder();
    }

    /**
     * 由于这里我们是反序构建Trie树，这样第一个字符就是当前输入的字符，然后再从后往前匹配之前输入过的字符，只需一次遍历之前查过的字符就可以完
     * 成查询。
     *
     * @param letter input letter
     */
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        int index;
        for (int i = sb.length()-1; i >= 0 ; i--) {
            index = sb.charAt(i)-'a';
            if (node.children[index] == null) { return false; }

            node = node.children[index];
            if (node.isEnding) { return true; }
        }

        return false;
    }

    /**
     * 由于题目需要记录之前查过的字符，然后在下一次接着查，所以所以如果顺序构建，每一次都要拿之前查过的字符与当前输入的字符拼成字符串查询没效率很
     * 低。所以这里我们考虑反序构建Trie树，这样第一个字符就是当前输入的字符，然后再从后往前匹配之前输入过的字符，只需一次遍历之前查过的字符就可
     * 以完成查询。
     *
     * @param patterns input pattern array
     */
    private void buildTrieTree(String[] patterns) {
        TrieNode node;
        int len, index;
        for (String pattern : patterns) {
            node = root;
            len = pattern.length();
            for (int i = len-1; i >= 0 ; i--) {
                index = pattern.charAt(i)-'a';
                if(node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEnding = true;
        }
    }
}
