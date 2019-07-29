package items;

public class LengthOfLastWord_58 {
    public static int lengthOfLastWord(String s) {
        int lastWordLength = 0;
        boolean firstCharacter = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                if (firstCharacter) break;
                else continue;
            lastWordLength++;
            firstCharacter = true;

        }
        return lastWordLength;
    }

//    public static int lengthOfLastWord(String s) {
//        String[] strings = s.split(" ");
//        return strings.length == 0 ? 0 : strings[strings.length-1].length();
//    }
}
