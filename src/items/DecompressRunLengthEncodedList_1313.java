package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class DecompressRunLengthEncodedList_1313 {

    /**
     * Simple solution with array list.
     *
     * @param nums input array
     * @return the decompressed RLE list
     */
    public int[] decompressRLElist1(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                ans.add(nums[i+1]);
            }
        }

        int[] res = new int[ans.size()];
        int index = 0;
        for (Integer num : ans) {
            res[index++] = num;
        }

        return res;
    }

    /**
     * Simple solution with array.
     *
     * @param nums input array
     * @return the decompressed RLE list
     */
    public int[] decompressRLElist2(int[] nums) {

        // calculate the length of the result array.
        int len = 0;
        for (int i = 0; i < nums.length - 1; i += 2) { len += nums[i]; }

        int[] res = new int[len];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                res[index++] = nums[i+1];
            }
        }

        return res;
    }
}
