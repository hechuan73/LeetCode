package algorithms.string.match;

import java.util.LinkedList;
import java.util.Queue;

/**
 * AcAutoMachine算法全称是Aho-Corasick算法。
 *
 * AcAutoMachine是在朴素Trie 树上进行多模式串匹配的改良，它加入了fail指针，fail指针指向另一个分支的某个字符节点，该分支到该节点所形成的字符
 * 串是当前已经部分匹配但遇到坏字符后匹配失败的模式串的最长可匹配后缀子串，然后开始新一轮的匹配，以此来加速匹配效率。这样在每次匹配失败后，就不用
 * 再只移一位又开始全新匹配。而是当匹配某个模式串失败时，会把已经匹配好的部分与其它模式串对比，避免全部从头对比。
 *
 * AcAutoMachine匹配主要包含三个步骤：
 * 1. 输入pattern字符串，构建trie tree；
 * 2. 在trie树上构建失败指针；
 * 3. 进行匹配
 *
 * 适用场景：敏感词汇匹配过滤等
 *
 * 复杂度分析：
 * 1. 构建trie tree：O(m*len)，m表示敏感词个数，len表示敏感词平均长度。
 * 2. 构建失败指针：内部while循环currFail = currFail.fail使得每次currFail指向节点的深度都至少减1，而树的高度不超过len，所以每个节点构建
 *    失败指针的时间复杂度为O(len)，整个过程就是O(k*len)，k表示Trie树中总的节点个数。不过AC自动机的构建过程都是预先处理好的，并不会频繁更新，
 *    不会影响匹配效率。
 * 3. 匹配：for循环遍历整个字符串，内部的while循环同第二步，时间复杂度为O(len)，所以总的时间复杂度为O(n*len)。因为敏感词一般不会很长，所以实
 *    际上匹配效率近似于O(n)。此外，实际上大部分敏感词的失败指针都可能指向root节点，所以绝大部分情况下ACAutoMachine上进行匹配效率远高于
 *    O(n*len)->O(n)，所以在ACAutoMachine上匹配会比朴素Trie上好很多，极端情况下才会退化为一样。
 *
 * 空间复杂度同Trie树。
 *
 *
 * @author hechuan
 */
public class AhoCorasick {

    private AcNode root;

    private AhoCorasick() {
        root = new AcNode();
    }

    /**
     * insert a pattern word into the trie tree.
     *
     * @param pattern pattern word
     */
    private void insert(String pattern) {
        AcNode node = root;
        int index;
        for (int i = 0; i < pattern.length(); i++) {
            index = pattern.charAt(i)-'a';
            if (node.children[index] == null) {
                node.children[index] = new AcNode();
            }

            node = node.children[index];
        }
        node.isEndingChar = true;
        node.length = pattern.length();
    }

    /**
     * Match the patterns in the input text.
     *
     * @param text input text
     * @return if match any pattern in the input text
     */
    private boolean match(String text) {
        char[] chars = text.toCharArray();
        int length = chars.length;

        AcNode node = root;
        int index;
        boolean res = false;
        for (int i = 0; i < length; i++) {
            index = chars[i]-'a';
            while (node.children[index] == null && node != root) {
                node = node.fail;
            }

            node = node.children[index];
            if (node == null) { node = root; }

            if (node != root && node.isEndingChar) {
                System.out.println("Start from: " + (i-node.length+1) + ",  Length is: " + node.length);
                res = true;
            }
        }

        return res;
    }

    /**
     * Match the patterns in the input text.
     *
     * @param text input text
     * @param patterns patterns to build ac trie tree
     * @return if match any pattern in the input text
     */
    public static boolean match(String text, String[] patterns) {
        AhoCorasick ahoCorasick = new AhoCorasick();
        for (String pattern : patterns) {
            ahoCorasick.insert(pattern);
        }

        ahoCorasick.buildFailurePointer();
        return ahoCorasick.match(text);
    }


    /**
     * for test
     */
    public static void test() {
        String[] strings = {"dfs", "ffr"};
        System.out.println(AhoCorasick.match("ddesdfsdffrgrf", strings));
    }

    /**
     * Build the failure pointer to enhance the matching process.
     */
    private void buildFailurePointer() {
        Queue<AcNode> queue = new LinkedList<>();
        root.fail = null;
        queue.add(root);

        AcNode curr, currChild, currFail, currFailChild;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            for (int i = 0; i < 26; i++) {
                currChild = curr.children[i];
                if (currChild == null) { continue;}
                if (curr == root) { currChild.fail = root; }
                else {
                    currFail = curr.fail;
                    while (currFail != null) {
                        currFailChild = currFail.children[i];
                        if (currFailChild != null) {
                            currChild.fail = currFailChild;
                            break;
                        }
                        currFail = currFail.fail;
                    }

                    if (currFail == null) { currChild.fail = root; }
                }

                queue.add(currChild);
            }
        }
    }

    public class AcNode {
        public AcNode[] children;
        public boolean isEndingChar;
        public int length = -1;
        public AcNode fail;

        public AcNode () {
            int charsetSize = 26;
            children = new AcNode[charsetSize];
        }
    }
}
