package items;

/**
 * @author hechuan
 */
public class CheckIfNAndItsDoubleExist_1346 {

    public boolean checkIfExist(int[] arr) {
        int[] buckets = new int[2001];

        for (int value : arr) {
            buckets[value + 1000]++;
        }

        // for the elements of [0, 500) and (1500, 2000], its double value is overflowing from the buckets array.
        for (int i = 500; i <= 1500; i++) {
            int index = 2*(i-1000)+1000;
            if (buckets[i] != 0 && index >= 0 && index <= 2000 && buckets[index] != 0) {
                if (index != i || buckets[index] > 1) { return true; }
            }
        }

        return false;
    }
}
