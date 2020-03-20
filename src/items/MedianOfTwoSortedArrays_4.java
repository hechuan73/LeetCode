package items;

/**
 * @author hechuan
 */
public class MedianOfTwoSortedArrays_4 {

    /**
     * Optimised solution with recursion.
     *
     * Time Complexity: O(log(m+n))
     * @param nums1 input array1
     * @param nums2 input array2
     * @return the median of the two sorted arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        // left half of the combined median.
        int left = (len1 + len2 + 1) / 2;
        // right half of the combined median.
        int right = (len1 + len2 + 2) / 2;

        // If the nums1.length + nums2.length is odd, the 2 function will return the same number.
        // Else if nums1.length + nums2.length is even, the 2 function will return the left number and right number that
        // make up a median.
        return (getKth(nums1, nums2, 0, 0, left) + getKth(nums1, nums2, 0, 0, right)) / 2.0;
    }

    private int getKth(int[] nums1, int[] nums2, int start1, int start2, int k) {
        // This function finds the Kth element in nums1 + nums2.

        // If nums1 is exhausted, return kth number in nums2.
        if (start1 >= nums1.length) { return nums2[start2+k-1]; }
        // If nums2 is exhausted, return kth number in nums1.
        if (start2 >= nums2.length) { return nums1[start1+k-1]; }
        // If k == 1, return the first number.
        // Since nums1 and nums2 is sorted, the smaller one among the start point of nums1 and nums2 is the first one.
        if (k == 1) { return Math.min(nums1[start1], nums2[start2]); }

        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        int index1 = start1 + k/2 - 1;
        int index2 = start2 + k/2 - 1;
        if (index1 < nums1.length) { mid1 = nums1[index1]; }
        if (index2 < nums2.length) { mid2 = nums2[index2]; }

        // Throw away half of the array from nums1 or nums2. And cut k in half.
        if (mid1 < mid2) {
            // [nums1Right + nums2Left].
            return getKth(nums1, nums2, start1+k/2, start2, k - k/2);
        }
        else {
            // [nums2Right + nums1Left]
            return getKth(nums1, nums2, start1, start2+k/2, k - k/2);
        }
    }
}
