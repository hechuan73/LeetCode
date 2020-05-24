package items;

import java.util.ArrayList;
import java.util.List;

public class ReformatTheString_1417 {

    public String reformat(String s) {
        if (s.length() == 0) { return ""; }
        List<Character> numbers = new ArrayList<>();
        List<Character> letters = new ArrayList<>();

        char cha;
        for (int i = 0; i < s.length(); i++) {
            cha =s.charAt(i);
            if (cha >= 'a') { letters.add(cha); }
            else { numbers.add(cha); }
        }

        int nLen = numbers.size(), lLen = letters.size();
        if (Math.abs(nLen-lLen) > 1) { return ""; }

        StringBuilder sb = new StringBuilder();
        boolean numberFirst = nLen >= lLen;
        int index = 0;
        while (index < nLen || index < lLen) {
            if (numberFirst) {
                sb.append(numbers.get(index));
                if (index < lLen) { sb.append(letters.get(index)); }
            }
            else {
                sb.append(letters.get(index));
                if (index < nLen) { sb.append(numbers.get(index)); }
            }

            index++;
        }

        return sb.toString();
    }
}
