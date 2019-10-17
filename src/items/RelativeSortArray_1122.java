package items;

/**
 * @author hechuan
 */
public class RelativeSortArray_1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // if the length of arr1 is more than 1000, we can use hash map to count the number times.
        int[] counter = new int[1001];
        // count the number times
        for (int i : arr1) { counter[i]++; }

        int index = 0;
        // write the numbers in arr2
        for (int i : arr2) {
            while (counter[i]-- > 0) {
                arr1[index++] = i;
            }
        }
        // write the numbers not in arr2
        for (int i = 0; i < counter.length; i++) {
            while (counter[i]-- > 0) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }
}
