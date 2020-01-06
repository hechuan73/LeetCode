package items;

/**
 * @author hechuan
 */
public class DetectCapital_520 {

    /**
     * Simple method but fastest.
     *
     * @param word input word
     * @return whether the word is using capital rightly.
     */
    public boolean detectCapitalUse1(String word) {
        int upperCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) <= 'Z') { upperCount++; }
        }

        if (upperCount == 0 || upperCount == word.length()) { return true; }
        return upperCount == 1 && word.charAt(0) <= 'Z';
    }

    /**
     * Solution with regular expression but slow.
     *
     * @param word input word
     * @return whether the word is using capital rightly.
     */
    public boolean detectCapitalUse2(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }

}
