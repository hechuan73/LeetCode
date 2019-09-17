package items;

public class FindPeakElement_162 {

    /**
     * As num[i] != nums[i+1] and nums[-1], nums[n] are infinitesimal, so we can traverse the array linearly, and find
     * the first element nums[i] which is larger than the next element, it is the first peak element.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums input array
     * @return the first peak element
     */
    public int findPeakElement1(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) { return i; }
        }

        return nums.length-1;
    }

    /**
     * We can use the binary search to find one of the peak elements. The binary search will decrease the searching
     * space gradually by checking whether nums[i] is larger than nums[i+1].
     *
     * Time Complexity: O(log(n))
     * Space Complexity: O(1)
     *
     * @param nums input array
     * @return one of the peak elements
     */
    public int findPeakElement2(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + ((high-low) >> 1);
            if (nums[mid] > nums[mid+1]) { high =  mid;}
            else { low = mid + 1; }
        }

        return low;
    }
}
