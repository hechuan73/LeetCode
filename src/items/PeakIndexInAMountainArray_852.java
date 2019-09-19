package items;

/**
 * @author hechuan
 */
public class PeakIndexInAMountainArray_852 {

    /**
     * Using binary search to find the peak element.
     *
     * @param A the input mountain array
     * @return the peak element
     */
    public int peakIndexInMountainArray(int[] A) {
        int low = 0, high = A.length-1;

        while (low < high) {
            int mid = low + ((high-low)>>1);
            if (A[mid] > A[mid+1]) { high = mid; }
            else { low = mid +1; }
        }

        return low;
    }
}
