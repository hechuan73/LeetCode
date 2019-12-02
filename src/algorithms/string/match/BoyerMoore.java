package algorithms.string.match;

import java.util.Arrays;

/**
 * @author hechuan
 */
public class BoyerMoore {

    private static final int CHARSET_SIZE = 256;

    /**
     * Boyer-Moore 算法是单模式串匹配算法。主要思想是主串与模式串从后往前匹配，遇到的第一个不能匹配的字符为"坏字符"，已经匹配上的子串为"好后缀"。
     * 算法主要包含两个部分，坏字符规则与好后缀规则。两个规则的目的都是在遇到不能匹配的字符时，可以将模式串向后移动一定长度，而不是移动一位逐一比
     * 较。好后缀规则可以独立使用，坏字符规则有缺陷，可能出现移动长度为负数的情况。
     *
     * 坏字符规则：在遇到坏字符时，在模式串查找是否存在能够匹配坏字符的位置，如果能够匹配，则一次性将模式串移动到匹配的位置，重新开始比较。如：
     *           root:    c a b c a b c a b         root:    c a b c a b c a b
     *           pattern: a c b               ->    pattern:   a c b
     *           如果模式串中有多个可以匹配坏字符的字符，取靠后的，避免移动过多。为了能够快速在模式串中找到是否有可以匹配的字符，我们可以先缓存
     *           模式串中字符的位置。假设坏字符在模式串中的下标为si，模式串中匹配坏字符的下标为xi，则移动的距离为si-xi，如果xi大于si，则可能
     *           出现移动长度为负数的情况。
     *
     * 好后缀规则：1. 拿长度为k好后缀在模式串中的前缀子串中查找是否有匹配的子串，如果有，将模式串移动到匹配好后缀的子串的位置。如果有多处匹配，
     *              取靠后的那个。
     *           2. 如果不存在匹配的子串，我们在好后缀的后缀子串[badChaIndex+2, patternLen-1]中，查找最长的、能跟模式串前缀子串匹配的后
     *              缀子串b[r, patternLen-1]，如果查找到，我们将模式串向后移动 r 位。
     *           3. 如果好后缀的后缀子串中，没有能跟模式串前缀子串匹配的后缀子串，模式串直接后移整个模式串长度patternLen。
     *
     * 最后，取两者移动长度更大的来进行移动。
     *
     * 复杂度分析：
     * Space Complexity：
     * 因为坏字符规则需要缓存模式串中字符所在的位置，其大小和字符集大小有关，所以担当字符集较大时，很消耗内存。而好后缀的空间消耗suffix和prefix
     * 都与模式串长度有关，所以较小。同时好后缀规则是独立的，可以单独使用，只是BM算法效率会下降。
     *
     * Time Complexity:
     * 坏字符预处理为O(m)，好后缀极端情况为O(m2)，即当有很多重复字符时，时间复杂度还可以优化，可以自行探究。但是BM算法时间复杂度分析很复杂，研
     * 究表明：最坏情况下，BM算法的比较次数上限是 3 * root.length
     *
     * BM算法的效率是KMP算法的3～4倍。
     *
     * @param root root string
     * @param pattern pattern string to be matched
     * @return the beginning index of in the root string if matched and first matched, otherwise return -1.
     */
    public static int match(String root, String pattern) {
        int rLen = root.length(), pLen = pattern.length();
        char[] rootChars = root.toCharArray();
        char[] patternChars = pattern.toCharArray();

        // init characters index hash table in pattern string.
        int[] charIndexes = new int[CHARSET_SIZE];
        initBadCharacters(patternChars, charIndexes);

        // init good suffix index hash table.
        int[] suffix = new int[pLen];
        boolean[] prefix = new boolean[pLen];
        initGoodSuffixArray(patternChars, suffix, prefix);

        // i is the index in root string, j is the index in pattern string
        int i = 0, j;
        int badChaMove, goodSuffixMove = 0;
        while (i <= rLen - pLen) {
            // 从后往前开始匹配，看是否存在坏字符/好后缀
            for (j = pLen-1; j >= 0; j--) {
                if (rootChars[i+j] != patternChars[j]) { break; }
            }

            // match successfully.
            if (j < 0) { return i; }

            // 坏字符规则需要移动的长度
            badChaMove = j-charIndexes[rootChars[i+j]];

            // 如果有已经匹配的好后缀，计算好后缀规则需要向后移动的长度
            if (j < pLen-1) { goodSuffixMove = moveByGoodSuffix(j, pLen, suffix, prefix); }

            // since the outer loop is the root string, so we we can move the root string instead of the pattern string.
            // i is the base index of root string, which representing range [i, i+pLen), so we add the distance to it.
            // i 选择坏字符与好后缀规则中向后移动长度大的来移动，同时可以避免坏字符移动出现负数的情况
            i += Math.max(badChaMove, goodSuffixMove);
        }

        return -1;
    }

    /**
     * 初始化模式串中每个字符的位置，以便于可以快速在模式串中找到与坏字符匹配的字符。如果有多个匹配的字符，记录靠后的位置，所以坏字符规则可能出现
     * 移动长度为负数的情况。
     *
     * @param pattern pattern string characters
     * @param charIndexes each bad character existing index in the pattern string except the current one.
     */
    private static void initBadCharacters(char[] pattern, int[] charIndexes) {
        Arrays.fill(charIndexes, -1);
        // save the index of character in pattern string.
        for (int i = 0; i < pattern.length; i++) { charIndexes[pattern[i]] = i; }
    }

    /**
     * 初始化suffix和prefix数组：
     * suffix数组：数组下标表示后缀子串的长度，数组值表示在模式串中跟好后缀相匹配的子串的起始下标值。
     * prefix数组：数组下标表示后缀子串的长度，数组值表示该长度的后缀能否与该长度的前缀子串匹配。
     *
     * [0, pLen-2]为公共前缀的范围
     * [1, pLen-1]为公共后缀的范围
     *
     * 用所有可取的子串（下标为[0, pLen-2]内，不一定是前缀子串，只是子串）与模式串求公共后缀子串，如果公共后缀子串的长度是k，那么我们就记录
     * suffix[k]=j（j表示公共后缀子串的起始下标），如果j=0，表示公共后缀子串也是模式串的前缀子串。
     * 例如：c a b c a b c a b:
     * 后缀子串'b': suffix[1] = 5, prefix[1] =false;
     * 后缀子串'ab': suffix[2] = 4, prefix[2] = false;
     * 后缀子串'cab': suffix[3] = 3, prefix[2] = true;
     * ......
     *
     * @param patternChars pattern string characters
     * @param suffix suffix array
     * @param prefix prefix array
     */
    private static void initGoodSuffixArray(char[] patternChars, int[] suffix, boolean[] prefix) {
        Arrays.fill(suffix, -1);
        Arrays.fill(prefix, false);

        int pLen = patternChars.length;
        int j, k;
        // patternChars[0, i] 与patternChars[0, pLen)求公共后缀子串，这样如果遇到公共后缀子串相同，也会记录靠后的子串，避免滑动过多
        // [0, pLen-2]为公共前缀的范围
        // [1, pLen-1]为公共后缀的范围
        for (int i = 0; i <= pLen-2; i++) {
            j = i;
            // 公共后缀子串长度
            k = 0;
            // 每次都会遍历patternChars[0, i]，来求公共后缀子串
            while (j >= 0 && patternChars[j] == patternChars[pLen-1-k]) {
                --j;
                ++k;
                suffix[k] = j+1;
            }
            // 公共后缀子串也是模式串的前缀子串
            if (j == -1) { prefix[k] = true; }
        }
    }

    /**
     * 好后缀规则主要包含三个部分：
     * 1. 拿长度为k好后缀在suffix数组在查找是否有匹配的子串，如果suffix[k] != -1，表示有匹配好后缀的子串，那我们将模式串向后移动
     *    badChaIndex-suffix[goodSuffixLen]+1。
     * 2. 如果suffix[k] == -1，表示不存在匹配的子串，我们在好后缀的后缀子串[badChaIndex+2, patternLen-1]中，查找最长的、能跟模式串前缀
     *    子串匹配的后缀子串b[r, patternLen-1]，如果查找到，我们将模式串向后移动 r 位。
     * 3. 如果好后缀的后缀子串中，没有能跟模式串前缀子串匹配的后缀子串，模式串直接后移整个模式串长度patternLen
     *
     * @param badChaIndex index of bad character
     * @param patternLen length of pattern string
     * @param suffix suffix array
     * @param prefix prefix array
     * @return moving length with good suffix rule
     */
    private static int moveByGoodSuffix(int badChaIndex, int patternLen, int[] suffix, boolean[] prefix) {
        int goodSuffixLen = patternLen-1-badChaIndex;
        // 如果模式串中有匹配好后缀的部分，模式串直接后移到该部分
        if (suffix[goodSuffixLen] != -1) { return badChaIndex-suffix[goodSuffixLen]+1; }
        // 如果模式串中没有完全匹配好后缀的部分，看能否在好后缀的后缀子串中，查找到最长的、能跟模式串前缀子串匹配的后缀子串
        for (int i = badChaIndex+2; i < patternLen ; i++) {
            // 长度为 (patternLen-1)-i+1 的后缀子串是否有能匹配的前缀子串
            if (prefix[patternLen - i]) { return i; }
        }

        // 如果好后缀的后缀子串中，没有能跟模式串前缀子串匹配的后缀子串，模式串直接后移整个模式串长度
        return patternLen;
    }
}
