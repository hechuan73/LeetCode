package items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hechuan
 */
public class PascalTriangle_118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) { return res; }
        if (numRows >= 1) { res.add(Collections.singletonList(1)); }

        List<Integer> subList, lastList;
        for (int i = 1; i < numRows; i++) {
            subList = new ArrayList<>();
            subList.add(1);
            for (int j = 1; j < i; j++) {
                lastList = res.get(i-1);
                subList.add(lastList.get(j-1) + lastList.get(j));
            }
            subList.add(1);
            res.add(subList);
        }

        return res;
    }
}
