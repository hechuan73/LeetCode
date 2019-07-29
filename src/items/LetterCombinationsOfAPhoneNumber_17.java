package items;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_17 {
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i < digits.length(); i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length() == i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

//    public static List<String> letterCombinations(String digits) {
//        Map<Character, List<Character>> digitToLetters = new HashMap<>();
//        digitToLetters.put('2', Arrays.asList('a', 'b', 'c'));
//        digitToLetters.put('3', Arrays.asList('d', 'e', 'f'));
//        digitToLetters.put('4', Arrays.asList('g', 'h', 'i'));
//        digitToLetters.put('5', Arrays.asList('j', 'k', 'l'));
//        digitToLetters.put('6', Arrays.asList('m', 'n', 'o'));
//        digitToLetters.put('7', Arrays.asList('p', 'q', 'r', 's'));
//        digitToLetters.put('8', Arrays.asList('t', 'u', 'v'));
//        digitToLetters.put('9', Arrays.asList('w', 'x', 'y', 'z'));
//
//        List<String> result = new ArrayList<>();
//        if (digits.length() != 0) backTrack("", digits, result, digitToLetters);
//
//        return result;
//    }
//
//    private static void backTrack(String combination, String digits, List<String> result,
//                                  Map<Character, List<Character>> digitToLetters) {
//        if (digits.length() == 0) {
//            result.add(combination);
//            return;
//        }
//
//        List<Character> letters = digitToLetters.get(digits.charAt(0));
//        for (char cha : letters) {
//            backTrack(combination + cha, digits.substring(1), result, digitToLetters);
//        }
//    }
//    public static List<String> letterCombinations(String digits) {
//        Map<Character, List<Character>> digitToLetters = new HashMap<>();
//        digitToLetters.put('2', Arrays.asList('a', 'b', 'c'));
//        digitToLetters.put('3', Arrays.asList('d', 'e', 'f'));
//        digitToLetters.put('4', Arrays.asList('g', 'h', 'i'));
//        digitToLetters.put('5', Arrays.asList('j', 'k', 'l'));
//        digitToLetters.put('6', Arrays.asList('m', 'n', 'o'));
//        digitToLetters.put('7', Arrays.asList('p', 'q', 'r', 's'));
//        digitToLetters.put('8', Arrays.asList('t', 'u', 'v'));
//        digitToLetters.put('9', Arrays.asList('w', 'x', 'y', 'z'));
//
//        List<String> result = new ArrayList<>();
//        List<String> tmpResult;
//        char[] chars = digits.toCharArray();
//
//        for (int i = 0; i < chars.length; i++) {
//            tmpResult = new ArrayList<>();
//            for (Character character : digitToLetters.get(chars[i])) {
//                if (i == 0) tmpResult.add(character.toString());
//                else for (String string : result) tmpResult.add(string + character);
//            }
//            result = tmpResult;
//        }
//
//
//        //result.forEach(e -> System.out.println(e + " "));
//        return result;
//    }
}
