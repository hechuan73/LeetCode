package Items;

public class LongestCommonPrefix_14 {

    public static String longestCommonPrefix(String[] strs) {

        StringBuilder commonString = new StringBuilder();

        if (strs.length == 0) return commonString.toString();

        // get the length of shortest string
        int commonLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) commonLength = strs[i].length() < commonLength ? strs[i].length() : commonLength;

        for (int i = 0; i < commonLength; i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) != strs[j+1].charAt(i)) {
                    flag = false;
                    break;
                }
            }

            if (flag) commonString.append(strs[0].charAt(i));
            else break;
        }

        return commonString.toString();
    }
}
