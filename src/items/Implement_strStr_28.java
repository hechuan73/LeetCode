package items;

public class Implement_strStr_28 {
    public  int strStr(String haystack, String needle) {
        //return needle.equals("")  ? 0 : haystack.indexOf(needle);

        if (needle.length() == 0) return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int k = i, count = 0;
                for (int j = 0; j < needle.length() && haystack.charAt(k) == needle.charAt(j); count++, j++, k++);
                if (count == needle.length()) return i;
            }
        }

        return -1;
    }
}
