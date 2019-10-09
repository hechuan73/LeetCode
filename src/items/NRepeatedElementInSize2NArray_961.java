package items;

/**
 * @author hechuan
 */
public class NRepeatedElementInSize2NArray_961 {

    /**
     * There are n+1 unique elements, and only one element repeats n times. So check if the A[i] == A[i-1] or
     * A[i] == A[i-2], and true return A[i], or not return -1.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param A input array
     * @return the element which repeats n times.
     */
    public int repeatedNTimes1(int[] A) {
        for (int i = 2; i < A.length; i++) {
            if (A[i] == A[i-1] || A[i] == A[i-2]) {return A[i];}
        }

        return -1;
    }

    /**
     * Using array to count the elements repeat times.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param A input array
     * @return the element which repeats n times.
     */
    public int repeatedNTimes2(int[] A) {
        int[] counter = new int[10000];

        for (int i : A) {
            if (counter[i]++ == 1) {return i; }
        }

        return -1;
    }
}
