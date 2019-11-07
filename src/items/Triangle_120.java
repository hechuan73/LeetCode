package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class Triangle_120 {

    /**
     * Down to up.
     *
     * @param triangle input triangle
     * @return the minimum path sum
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 0) { return 0; }

        List<Integer> curr, next;
        for (int i = size - 2; i >= 0; i--) {
            curr = triangle.get(i);
            next = triangle.get(i+1);

            for (int j = 0; j < curr.size(); j++) {
                curr.set(j, curr.get(j) + Math.min(next.get(j), next.get(j+1)));
            }
        }

        return triangle.get(0).get(0);
    }

    /**
     * Up to down.
     *
     * @param triangle input triangle
     * @return the minimum path sum
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle.size() == 0) { return 0; }
        if (triangle.size() == 1) { return triangle.get(0).get(0); }

        List<Integer> currList = new ArrayList<>(), lastList;
        for (int i = 1; i < triangle.size(); i++) {
            lastList = triangle.get(i-1);
            currList = triangle.get(i);
            for (int j = 0; j < currList.size(); j++) {
                if (j == 0) { currList.set(j, currList.get(j) + lastList.get(j)); }
                else if (j == currList.size()-1) { currList.set(j, currList.get(j) + lastList.get(j-1)); }
                else {
                    currList.set(j, currList.get(j) + Math.min(lastList.get(j), lastList.get(j-1)));
                }
            }
        }

        int res = currList.get(0);
        for (int i = 1; i < currList.size(); i++) {
            res = Math.min(res, currList.get(i));
        }

        return res;
    }
}
