package items;

import java.util.Arrays;

/**
 * @author hechuan
 */
public class SumOfMutatedArrayClosestToTarget_1300 {

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int[] sums = new int[arr.length];
        sums[0] = arr[0];
        for (int i = 1; i < arr.length; i++) { sums[i] = arr[i] + sums[i-1]; }

        int index, res = Integer.MAX_VALUE, diff = Integer.MAX_VALUE;
        int tmpDiff;
        for (int i = 0; i <= arr[arr.length-1] ; i++) {
            index = Arrays.binarySearch(arr, i);
            if (index >= 0) { tmpDiff = Math.abs(sums[index] + i*(arr.length-index-1) - target); }
            else {
                index = -(index+1);
                if (index == 0) { tmpDiff = Math.abs(i*arr.length - target); }
                else { tmpDiff = Math.abs(sums[index-1] + i*(arr.length-index) - target); }
            }

            if (tmpDiff == diff) { res = Math.min(res, i); }
            if (tmpDiff < diff) {
                diff = tmpDiff;
                res = i;
            }
        }

        return res;
    }

}
