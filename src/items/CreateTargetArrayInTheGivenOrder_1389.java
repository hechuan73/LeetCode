package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class CreateTargetArrayInTheGivenOrder_1389 {

    public int[] createTargetArray(int[] nums, int[] index) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(index[i], nums[i]);
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
