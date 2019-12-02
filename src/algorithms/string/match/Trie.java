package algorithms.string.match;

import items.TrieNode;

/**
 * Trie树也叫"字典树"，是一种专门用于字符串匹配的数据结构，是一种多模式的字符串匹配的解决方案，用于解决在一组字符串中查找某个字符串的问题。Trie
 * 树的本质是利用字符串中的公共前缀，将重复的前缀合并在一起。
 *
 * Trie树中，根结点不包含任何信息，其余每一个结点表示一个字符串中的一个字符，从根结点到叶子结点的路径表示一个字符串。
 * Trie树主要包含两个操作：将一个字符串集构成一个trie树以及在trie树中查询一个一个字符串。
 *
 * 这里我们实现一种最简单的trie树，设它的字符集为a~z 26个字母，我们用一个数组存储其所有子节点，如果子节点不为null，其下标即表示它对应的的字符，
 * 同时每一个节点都会有一个标志变量，以标示它是否为结尾字符。如果是，则从根结点到该节点的路径形成对应的字符串。
 *
 * 复杂度分析：
 * 时间复杂度：
 * 1. 构建Trie树，时间复杂度为O(n)，n表示所有字符串的长度之和。
 * 2. 在Trie树中查询某个字符串O(k)，k为待查询字符串的长度k。
 *
 * 空间复杂度：Trie树特别耗内存，因为每一个节点都需要保存一个字符集数组。
 *
 * 对于在一组字符串中查询某个字符串，Trie树与散列表的比较：
 * 缺点：
 * 1. 字符集不能太大，太大会很耗内存。
 * 2. 要求字符串的前缀重合要比较多，不然会很耗内存。
 * 3. 如果要用Trie树解决问题，我们需要自己实现一个Trie树，将工程问题复杂化了。
 * 4. Trie树中用到了指针，对于CPU缓存不友好，性能上有折扣。
 *
 * 适用场景：（非精确匹配的搜索）
 * 1. 查找前缀匹配的字符串，如搜索引擎中输入某个字符后的搜索推荐。
 * 2. IDE代码补全。
 * 3. 浏览器网址输入自动补全等
 * 4. 路由表匹配
 *
 * 优化：
 * 1. 节点压缩：对于只有一个子节点的节点，而且此子节点不是一个串的结束节点，将此节点与子节点存到一个节点中。
 * 2. 存储字符集的数组采用动态数组，红黑树，散列表等，牺牲一部分查询性能。
 *
 * Follow up question：
 * 1. 如果字符集包含中文怎么处理？
 * 2. 如果词库中关键词很多，输入一个关键词后可匹配的关键词也很多，那么应该推荐哪些关键词？
 * 3. 如果输入单词拼写错误，如何进行矫正？（好像是用贝叶斯纠错）
 *
 * @author hechuan
 */
public class Trie {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     *
     * @param word word to be inserted
     */
    public void insert(String word) {
        TrieNode p = root;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode();
            }
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
            index = word.charAt(i) - 'a';
            if (p.children[index] == null) {
                return false;
            }
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
            index = prefix.charAt(i) - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }

        return true;
    }

}
