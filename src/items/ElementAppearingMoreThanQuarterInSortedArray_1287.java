package items;

/**
 * @author hechuan
 */
public class ElementAppearingMoreThanQuarterInSortedArray_1287 {

    /**
     * Simple method.
     *
     * @param arr input array
     * @return the element which appears more than 25% of the array length.
     */
    public int findSpecialInteger1(int[] arr) {
        int count = 1;
        int quarter = arr.length / 4;

        for (int i = 1; i < arr.length; i++) {
            if (count > quarter) { return arr[i-1]; }
            if (arr[i] == arr[i-1]) { count++; }
            else { count = 1; }
        }

        return arr[arr.length-1];
    }

    /**
     * Simple method.
     *
     * @param arr input array
     * @return the element which appears more than 25% of the array length.
     */
    public int findSpecialInteger2(int[] arr) {
        int quarter = arr.length / 4;
        int diff = arr.length - quarter;
        for (int i = 0; i < diff; i++) {
            if (arr[i] == arr[i+quarter]) { return arr[i]; }
        }

        return -1;
    }
}
