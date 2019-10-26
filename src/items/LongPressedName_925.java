package items;

/**
 * @author hechuan
 */
public class LongPressedName_925 {

    public boolean isLongPressedName(String name, String typed) {
        int j = 0;
        for (int i = 0; i < typed.length() && j < name.length(); i++) {
            if (name.charAt(j) == typed.charAt(i)) { j++; }
        }

        return j == name.length();
    }
}
