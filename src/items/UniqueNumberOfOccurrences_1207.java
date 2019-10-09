package items;

/**
 * @author hechuan
 */
public class UniqueNumberOfOccurrences_1207 {

    public boolean uniqueOccurrences(int[] arr) {
        int[] elementCounter = new int[2001];
        int[] timeCounter = new int[1000];

        for (int i : arr) {
            elementCounter[i+1000]++;
        }

        for (int value : elementCounter) {
            if (value != 0 && timeCounter[value]++ == 1) {
                return false;
            }
        }

        return true;
    }
}
