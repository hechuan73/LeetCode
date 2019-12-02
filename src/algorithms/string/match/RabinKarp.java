package algorithms.string.match;

/**
 * @author hechuan
 */
public class RabinKarp {

    private static final int CHARSET_SIZE = 26;
    private static final int[] POWER_TABLE = new int[CHARSET_SIZE];

    static {
        POWER_TABLE[0] = 1;
        for (int i = 1; i < CHARSET_SIZE; i++) {
            POWER_TABLE[i] = POWER_TABLE[i-1]* CHARSET_SIZE;
        }
    }

    /**
     * Rabin-Karp Algorithm: using cache to optimise the Brute Force matching algorithm.
     * 由于BF算法中，每次检查主串与模式串是否匹配，都需要一次比对每个字符，时间复杂度较高，所以我们引入哈希算法。
     *
     * 算法是单模式串匹配算法。
     * 主要思路如下：设主串长度为n，模式串长度为m，我们通过hash算法对主串中的n-m+1个子串分别求哈希值，然后逐个与模式串的哈希值比较大小。如果某
     * 个子串的哈希值与模式串相等，那就说明子串与模式串匹配了（先不考虑哈希冲突）。因为哈希值是一个数字，数字之间比较是否相等是很快的，所以模式串
     * 与子串的比较效率较高。
     *
     * 由于计算子串的hash值，仍然需要便利子串中的每一个字符。尽管模式串与子串的比较效率提高，但整体效率并没有提高。所以需要通过有技巧的设计hash
     * 算法，来提高计算子串hash值的效率。
     *
     * 提供一个最简单的hash算法设计：假设待处理的字符串其字符集为a~z 26个小写字母，那么就用一个26进制数来表示一个字符串，这样他们就一一对应。
     * 如："cba" = 'c' * 26^2 + 'b' * 26^1 + a * 26^0.
     *
     * 这样的hash算法有一个特点，就是主串中相邻的两个字串的hash公式计算有一定关系（如果完全没有关系，那么每计算一个子串就要全部重新遍历每一个字
     * 符，效率较低）：
     * h[i-1]对应子串S[i-1, i+m-2]的哈希值，h[i-1]对应子串S[i, i+m-1]的哈希值：
     *    h[i-1] = 26^(m-1) * (S[i-1]-'a') + 26^(m-2) * (S[i]-'a') + ... + 26^0 * (S[i+m-2]-'a')
     *    h[i] =                             26^(m-1) * (S[i]-'a') + ... + 26^1 * (S[i+m-2]-'a') + 26^0 * (S[i+m-1]-'a')
     *
     * 所以计算得：h[i] = 26*(h[i-1 - 26^(m-1)*(S[i-1)-'a') + 26^0 * (S[i+m-1)-'a'。这样我们只需要遍历一边主串，就可以计算出所有主
     * 串中子串的hash值了。
     *
     * 注意：
     * 1. 所有26的幂次值，我们都可以提前计算出来，存在数组中，数组的下标为幂次数，每次直接取即可。由于使用int/long都可能越界，但这里对于简单计
     *    算影响不大，实际设计可以参考2，3。
     * 2. 对于hash值太大可能会越界的问题，我们可以牺牲一下，允许hash冲突，重新设计hash算法，使得哈希值落在int/long范围内：比如每次取每个字符
     *    对应的数字相加，不求幂（"cba" = 2 + 1 + 0），这样可能冲突概率较高，或者将每个字母从小到大对应一个素数，而不是1，2，3这种自然数，冲
     *    突概率也会下降。
     * 3. 如果发生了哈希冲突，那我们再将子串与模式串逐字符比较一下即可。
     * 4. 优化1：先计算模式串的hash值，这样每计算一个子串hash值就比较一下，一旦匹配，就可以返回（如果考虑hash冲突，可以再逐一比较下），不用计
     *          算后续的子串hash值。
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     *
     * @param root root string
     * @param pattern pattern string to be matched
     * @return the beginning index of in the root string if matched, otherwise return -1.
     */
    public static int match(String root, String pattern) {
        char[] rootChars = root.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int rLen = root.length(), pLen = pattern.length();
        int subStrLen = rLen-pLen+1;
        int[] hashes = new int[subStrLen];

        // calculate the hash of the pattern string.
        int patternHash = 0;
        for (int i = 0; i < pLen; i++) { patternHash += (patternChars[i]-'a')* POWER_TABLE[pLen-i-1]; }

        // init hash of substring in root string.
        int sum = 0;
        for (int j = 0; j < pLen; j++) { sum += (rootChars[j]-'a')* POWER_TABLE[pLen-j-1]; }
        hashes[0] = sum;
        for (int i = 1; i < subStrLen; i++) {
            // compare the pattern hash to the substrings hashes.
            if (patternHash == hashes[i-1]) {return i-1; }
            // h[i] = 26*(h[i-1 - 26^(m-1)*(S[i-1)-'a') + 26^0 * (S[i+m-1)-'a'
            hashes[i] = CHARSET_SIZE *(hashes[i-1] - (rootChars[i-1]-'a')* POWER_TABLE[pLen-1]) + (rootChars[i+pLen-1]-'a');
        }

        return -1;
    }
}
