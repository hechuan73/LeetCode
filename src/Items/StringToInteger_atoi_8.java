package Items;

public class StringToInteger_atoi_8 {
    /**
     * 1. discards all leading whitespaces
     * 2. sign of the number
     * 3. overflow
     * 4. invalid input
     * Integer.MAX_VALUE = 2147483647   Integer.MIN_VALUE = -2147483648
     *
     * @param str input string
     * @return result integer
     */
    public static int myAtoi(String str) {
        str = str.trim();
        char[] chars = str.toCharArray();
        int isPositive = 1;
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                if (chars[i] == '-') isPositive = -1;
                else if (chars[i] == '+') ;
                else if (chars[i] >= '0' && chars[i] <= '9') result = chars[i] - '0';
                else return 0;
            }
            else {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && chars[i] > '7'))
                        return isPositive == 1 ?Integer.MAX_VALUE : Integer.MIN_VALUE;

                    result = result * 10 + chars[i]- '0';
                }
                else break;
            }
        }

        return isPositive * result;
    }


//    public static int myAtoi(String str) {
//        if (str.length() == 0) return 0;
//        char[] chars = str.toCharArray();
//        StringBuilder stringBuilder = new StringBuilder();
//
//        if ((chars[0] >= 48 && chars[0] <= 57) || chars[0] == 32) construct(chars, stringBuilder);
//
//        else if (chars[0] == 43 || chars[0] == 45) {
//            if (chars.length == 1 || chars[1] < 48 || chars[1] > 57) return 0;
//            construct(chars, stringBuilder);
//        }
//        else return 0;
//
//        if (stringBuilder.length() == 0) return 0;
//        String tmp = stringBuilder.toString().replaceAll(" ", "");
//
//        if (tmp.length() == 1 && (tmp.equals("+") || tmp.equals("-")) ) return 0;
//        if (tmp.length() > 1 &&
//                ( tmp.startsWith("++")
//                        || tmp.startsWith("+-")
//                        || tmp.startsWith("--")
//                        || tmp.startsWith("-+")
//                ) ) return 0;
//
//        chars = tmp.toCharArray();
//        if (chars[0] == 43) tmp = tmp.replaceFirst("\\+", "").replaceFirst("^0*", "");
//        else if (chars[0] == 45) tmp = "-" + tmp.replaceFirst("-", "").replaceFirst("^0*", "");
//        else tmp = tmp.replaceFirst("^0*", "");
//
//        if (tmp.length() == 0) return 0;
//        if (tmp.length() == 1 && (tmp.equals("+") || tmp.equals("-")) ) return 0;
//        if (chars[0] != 45 && tmp.length() > 11) return Integer.MAX_VALUE;
//        if (chars[0] == 45 && tmp.length() > 11) return Integer.MIN_VALUE;
//        long result = Long.parseLong(tmp);
//        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
//        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
//
//        return (int) result;
//    }
//
//    private static void construct(char[] chars, StringBuilder stringBuilder) {
//        for (char c : chars) {
//            if (c > 57) break;
//            if (c >= 48) stringBuilder.append(c);
//            if (c == '.') break;
//
//
//            if (c == 45) {
//                if (stringBuilder.toString().replaceAll(" ", "").equals("")) stringBuilder.append(c);
//                else break;
//            }
//
//            if (c == 43) {
//                if (stringBuilder.toString().replaceAll(" ", "").equals("")) stringBuilder.append(c);
//                else break;
//            }
//
//            if (c == 32 && !stringBuilder.toString().replaceAll(" ", "").equals("")) break;
//        }
//    }
}
