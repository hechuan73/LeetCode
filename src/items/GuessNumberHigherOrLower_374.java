package items;

/**
 * @author hechuan
 */
public class GuessNumberHigherOrLower_374 {

    private int pickNum = 10;

    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + ((high-low)>>1);
            int diff = guess(mid);
            if (diff == 0) { return mid; }
            else if (diff < 0) { low = mid + 1; }
            else { high = mid - 1; }
        }

        return -1;
    }

    private int guess(int n) {
        return Integer.compare(pickNum, n);
    }
}
