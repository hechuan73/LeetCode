package items;

/**
 * @author hechuan
 */
public class ReplaceElementsWithGreatestElementOnRightSide_1299 {

    /**
     * Traverse backwards.
     *
     * @param arr input array
     * @return the replaced array
     */
    public int[] replaceElements(int[] arr) {
        int max = -1, tmp;
        for (int i = arr.length - 1; i >= 0; i--) {
            tmp = arr[i];
            arr[i] = max;
            max = Math.max(max, tmp);
        }

        return arr;
    }
}
