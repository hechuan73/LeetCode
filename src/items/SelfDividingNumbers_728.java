package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class SelfDividingNumbers_728 {

    /**
     * Simple method.
     *
     * @param left left boundary
     * @param right right boundary
     * @return the list of self dividing numbers
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();

        int num, remainder;
        for (int i = left; i <= right; i++) {
            num = i;
            while (num != 0) {
                if ((remainder = num % 10) != 0 && (i % remainder == 0)) { num /= 10; }
                else { break;}
            }

            if (num == 0) { res.add(i); }
        }

        return res;
    }
}
