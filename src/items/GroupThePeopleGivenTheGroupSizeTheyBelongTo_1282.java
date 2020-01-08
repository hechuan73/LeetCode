package items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hechuan
 */
public class GroupThePeopleGivenTheGroupSizeTheyBelongTo_1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<Integer>[] groups = new List[groupSizes.length+1];

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (groups[groupSizes[i]] == null) { groups[groupSizes[i]] = new ArrayList<>(); }
            groups[groupSizes[i]].add(i);
            if (groups[groupSizes[i]].size() == groupSizes[i]) {
                res.addAll(Collections.singleton(groups[groupSizes[i]]));
                groups[groupSizes[i]] = new ArrayList<>();
            }
        }

        return res;
    }
}
