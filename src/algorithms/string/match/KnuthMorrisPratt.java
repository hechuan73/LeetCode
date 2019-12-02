package algorithms.string.match;

/**
 * @author hechuan
 */
public class KnuthMorrisPratt {

    /**
     * Knuth-Morris-Pratt (KMP)算法是单模式串匹配算法。算法主要思想是主串与模式串从前往后匹配，遇到的第一个不能匹配的字符为"坏字符"，已经匹配上的
     * 子串为"好前缀"。每次在好前缀串中查找能够最长的匹配好前缀串后缀子串的前缀子串，并将模式串移动，使得最长的可匹配的前缀子串与后缀子串对其，然
     * 后将坏字符与最长可匹配前缀子串的下一个字符进行比较。算法的思想也是在遇到不能匹配的字符时，可以将模式串向后移动一定长度，而不是移动一位逐一
     * 比较。
     *
     * 由于已经匹配上的好前缀也是模式串的一部分，为了在遇到坏字符时，能够在好前缀中快速查找到最长的可匹配的好前缀子串，我们可以对模式串进行预处
     * 理生成next数组（失效函数），它的下标i表示模式串中子串pattern[0, i]的结尾字符下标i，值next[i]=k表示能够匹配该子串的后缀子串的最长前缀
     * 子串的结尾字符下标。使得对于模式串的子串pattern[0, i]，可以快速找到它的最长可匹配的前缀子串的结尾字符next[i]=k。如：
     * pattern：a b a b a c d
     *     i     0    1    2      3       4        5
     *    子串    a   ab   aba   abab    ababa   ababac
     * next[i]   -1  -1    0      1       2        -1
     *
     * 复杂度分析：
     * KMP算法主要包含两部分，构建next数组和借助next数组进行匹配。
     *
     * 对于第一部分：由于while循环的次数不好统计，所以我们借助参照变量i和k从侧面分析。i从1i之增加到m，而k并不是每次循环都增加，所以k累计的值肯
     * 定小于模式串长度m，而while循环中k=next[k]实际上是在减小k，而k累积都没有增加超过m，所以while循环总执行次数也不可能超过m(常数级其实)，
     * 所以next数组的计算时间复杂度为O(m)。
     *
     * 对于第二部分：i从0增加到主串长度n-1，而while循环中每次，j的增长量不可能超过i所以肯定小于n，其实j = next[j-1]+1也是在让j减小，由于j
     * 累积都没有增加超过n，所以while循环总执行次数也不可能超过n(常数级其实)，所以比较部分的计算时间复杂度为O(n)。
     *
     * 所以总的时间复杂度为O(m+n)。
     * 空间复杂度：O(m) 用于存储next数组
     *
     * @param root root string
     * @param pattern pattern string to be matched
     * @return the beginning index of in the root string if matched and first matched, otherwise return -1.
     */
    public static int match(String root, String pattern) {
        int rLen = root.length(), pLen = pattern.length();
        char[] rChars = root.toCharArray();
        char[] pChars = pattern.toCharArray();
        int[] next = initNextArray(pChars);

        int j = 0;
        for (int i = 0; i < rLen; i++) {
            // 当遇到坏字符，发生不匹配的情况
            while (j > 0 && rChars[i] != pChars[j]) {
                // j-1表示好前缀的结尾字符下标，next[j-1]表示模式串中最长可匹配的前缀的结尾字符下标，即pattern[0, j-1]是与主串中的后缀子
                // 串匹配的，所以我们将j后移到最长可匹配next[j-1]的后一位，开始新一轮的匹配比较。
                j = next[j-1] + 1;
            }

            // 如果对应下标的字符相等，模式串中下标后移一位
            if (rChars[i] == pChars[j]) { j++; }
            // 全部匹配成功，返回主串中的起始下标
            if (j == pLen) { return i - pLen + 1;}
        }

        return -1;
    }

    /**
     * 初始化next数组：
     * next数组：下标i表示模式串中子串patternChars[0, i]的结尾字符下标i，值next[i]=k表示能够匹配该子串的后缀子串的最长前缀子串的结尾字符
     * 下标k。
     *
     * 流程中，设patternChars[0, k]表示已经可以与子串patternChars[0, i-1]的后缀子串匹配的前缀子串，则我们判断下一个字符
     * patternChars[k+1] 与 patternChars[i]是否匹配。如果匹配，更新k，同时设置next[i]=k。如果不匹配我们则将寻找范围从[0, i-1]更新为
     * [0, k]，因为我们始终需要保证找到的前缀子串能与patternChars[0, i-1]的后缀子串匹配，而patternChars[0, k]已经是[0, i-1]范围内可匹
     * 配后缀子串的前缀子串，所以再在[0, k]范围内寻找前缀子串，它也一定是能够与patternChars[0, i-1]的后缀子串匹配。接着我们继续比较
     * patternChars[k+1] 与 patternChars[i]是否匹配。
     *
     * @param patternChars pattern characters
     * @return next array
     */
    private static int[] initNextArray(char[] patternChars) {
        int[] next = new int[patternChars.length];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < patternChars.length; i++) {
            // patternChars[0, k]表示已经可以与子串patternChars[0, i-1]的后缀子串匹配的前缀子串，所以现在比较下一位patternChars[k+1]
            // 是否能与patternChars[i]匹配
            while (k != -1 && patternChars[k+1] != patternChars[i]) {
                // 如果不能匹配，k表示好前缀的结尾字符下标，next[k]表示模式串中最长可匹配的前缀的结尾字符下标，所以将k移动到模式串[0, k]范
                // 围内最长可以匹配的前缀子串的结尾下标，以开始新一轮的比较：即比较以匹配的部分的下一位是否可以与子串最后一位patternChars[i]
                // 匹配，从而得出对于子串patternChars[0, i]的最长可匹配的前缀子串。
                k = next[k];
            }

            // patternChars[0, k]表示已经可以与子串patternChars[0, i-1]的后缀子串匹配的前缀子串，如果两者的下一位依然可以匹配，那么将k
            // 后移一位，以便于设置子串patternChars[0, i]的最长可匹配的前缀子串next[i]。
            if (patternChars[k+1] == patternChars[i]) { k++; }
            // 设置子串patternChars[0, i]的最长可匹配的前缀子串 next[i] = k。
            next[i] = k;
        }

        return next;
    }
}
