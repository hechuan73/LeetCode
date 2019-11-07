package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class PascalTriangleII_119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) { return res; }

        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) { res.set(j, res.get(j) + res.get(j-1)); }
            res.add(1);
        }

        return res;
    }
}
