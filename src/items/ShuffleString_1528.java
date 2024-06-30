package items;

/**
 * @author hechuan
 */
public class ShuffleString_1528 {

    public String restoreString(String s, int[] indices) {
        char[] chars = new char[indices.length];
        char[] sChas = s.toCharArray();
        for (int i = 0; i < indices.length; i++) {
            chars[indices[i]] = sChas[i];
        }

        return String.valueOf(chars);
    }
}
