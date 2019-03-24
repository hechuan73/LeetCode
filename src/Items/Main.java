package Items;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        System.out.println(myAtoi(" -1010023630o4"));
//        System.out.println(myAtoi("    -42"));
//        System.out.println(myAtoi("4193 with words"));
//        System.out.println(myAtoi("words and 987"));
//        System.out.println(myAtoi("-91283472332"));
//        System.out.println(myAtoi("-"));
//        System.out.println(myAtoi(""));
//        System.out.println(myAtoi("20000000000000000000"));
//        System.out.println(myAtoi("1-0"));
        System.out.println(myAtoi("  -0k4"));
        //System.out.println("+00000123".replaceFirst("\\+", "").replaceFirst("^0*","" ));
    }

    public static int myAtoi(String str) {
        if (str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        if ((chars[0] >= 48 && chars[0] <= 57) || chars[0] == 32) construct(chars, stringBuilder);

        else if (chars[0] == 43 || chars[0] == 45) {
            if (chars.length == 1 || chars[1] < 48 || chars[1] > 57) return 0;
            construct(chars, stringBuilder);
        }
        else return 0;

        if (stringBuilder.length() == 0) return 0;
        String tmp = stringBuilder.toString().replaceAll(" ", "");

        if (tmp.length() == 1 && (tmp.equals("+") || tmp.equals("-")) ) return 0;
        if (tmp.length() > 1 &&
                ( tmp.startsWith("++")
                        || tmp.startsWith("+-")
                        || tmp.startsWith("--")
                        || tmp.startsWith("-+")
                ) ) return 0;

        chars = tmp.toCharArray();
        if (chars[0] == 43) tmp = tmp.replaceFirst("\\+", "").replaceFirst("^0*", "");
        else if (chars[0] == 45) tmp = "-" + tmp.replaceFirst("-", "").replaceFirst("^0*", "");
        else tmp = tmp.replaceFirst("^0*", "");

        if (tmp.length() == 0) return 0;
        if (tmp.length() == 1 && (tmp.equals("+") || tmp.equals("-")) ) return 0;
        if (chars[0] != 45 && tmp.length() > 11) return Integer.MAX_VALUE;
        if (chars[0] == 45 && tmp.length() > 11) return Integer.MIN_VALUE;
        long result = Long.parseLong(tmp);
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) result;
    }

    private static void construct(char[] chars, StringBuilder stringBuilder) {
        for (char c : chars) {
            if (c > 57) break;
            if (c >= 48) stringBuilder.append(c);
            if (c == '.') break;


            if (c == 45) {
                if (stringBuilder.toString().replaceAll(" ", "").equals("")) stringBuilder.append(c);
                else break;
            }

            if (c == 43) {
                if (stringBuilder.toString().replaceAll(" ", "").equals("")) stringBuilder.append(c);
                else break;
            }

            if (c == 32 && !stringBuilder.toString().replaceAll(" ", "").equals("")) break;
        }
    }
}


