package items;

/**
 * @author hechuan
 */
public class ZigZagConversion_6 {

    /**
     * Simple two phases solution.
     *
     * Time Complexity: O(n)
     *
     * @param s input string
     * @param numRows input rows
     * @return the converted string
     */
    public static String convert1(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        // Reference elements must need to init one by one!
        for (int i = 0; i <sbs.length ; i++) { sbs[i] = new StringBuilder(); }

        for (int i = 0; i < s.length();) {

            // up to down
            for (int j = 0; j < numRows && i < s.length(); j++) {
                sbs[j].append(s.charAt(i++));
            }

            // down to up
            for (int j = numRows - 2; j > 0 && i < s.length(); j--) {
                sbs[j].append(s.charAt(i++));
            }

        }

        for (int i = 1; i < sbs.length; i++) { sbs[0].append(sbs[i]); }

        return sbs[0].toString();
    }

    /**
     * Simple direct solution.
     *
     * Time Complexity: O(n)
     *
     * @param s input string
     * @param numRows input rows
     * @return the converted string
     */
    public String convert2(String s, int numRows) {
        if (numRows <= 1) { return s; }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i <sbs.length ; i++) { sbs[i] = new StringBuilder(); }
        int index = 0, increment = 0;
        for (int i = 0; i < s.length(); i++) {
            sbs[index].append(s.charAt(i));
            if (index == 0) { increment = 1;}
            if (index == numRows-1) { increment = -1; }
            index += increment;
        }

        for (int i = 1; i < sbs.length; i++) { sbs[0].append(sbs[i]); }

        return sbs[0].toString();
    }
}
