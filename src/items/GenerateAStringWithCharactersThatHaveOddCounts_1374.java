package items;

/**
 * @author hechuan
 */
public class GenerateAStringWithCharactersThatHaveOddCounts_1374 {

    public String generateTheString1(int n) {
        return "b" + "ab".substring(n % 2, 1 + n % 2).repeat(n - 1);
    }

    public String generateTheString2(int n) {
        if (n <= 0) { return ""; }
        StringBuilder res = new StringBuilder();
        if ((n & 1) == 0) {
            res.append("a".repeat(Math.max(0, n - 1)));
            res.append('b');
        }
        else { res.append("a".repeat(Math.max(0, n))); }

        return res.toString();
    }
}
