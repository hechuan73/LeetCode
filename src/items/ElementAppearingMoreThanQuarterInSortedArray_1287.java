package items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * Optimised method.
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

    /**
     * Super method.
     *
     * In sorted, we can avoid linear search:
     * 1. Find the element at position n/4
     * 2. Perform a binary search to find the first occurrence of that item.
     * 3. Perform a binary search to find the last occurrence of that item.
     * 4. If last-first+1 > n/4, you have your answer. Otherwise repeat the process for n/2 and 3(n/4).
     *
     * Time Complexity: O(logn)
     *
     * @param arr input array
     * @return the element which appears more than 25% of the array length.
     */
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        if(n==1) { return arr[0]; }

        List<Integer> list = new ArrayList<>(Arrays.asList(arr[n/4],arr[n/2],arr[(3*n)/4]));
        for (int element : list) {
            int f = firstOccurrence(arr,element);
            int l = lastOccurrence(arr,element);
            if(l-f+1 > n/4) {
                return element;
            }
        }
        return -1;
    }

    private int firstOccurrence(int[] nums, int target) {
        int start=0;
        int end = nums.length-1;
        while(start < end){
            int middle = start + (end - start)/2;
            if(nums[middle]==target && (middle==start || nums[middle-1]<target)) { return middle; }
            if(target > nums[middle]) { start = middle + 1; }
            else { end = middle; }
        }
        return start;

    }

    private int lastOccurrence(int[] nums,int target) {
        int start=0;
        int end = nums.length-1;
        while(start < end){
            int middle = start + (end - start)/2;
            if(nums[middle]==target && (middle==end || nums[middle+1]>target)) { return middle; }
            if(nums[middle] > target) { end = middle; }
            else { start = middle + 1; }
        }
        return start;

    }
}
