package items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hechuan
 */
public class FourDivisors_1390 {

    private int res = 0;
    public int sumFourDivisors(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            findFourDivisors(num);
        }

        return res;
    }

    private void findFourDivisors(int num) {
        if (num > 5) {
            boolean flag = false;
            int divisor = 0;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    if (flag) { return; }
                    else {
                        if (i != Math.sqrt(num)) {
                            flag = true;
                            divisor = i;
                        }
                    }
                }
            }

            if (flag) {
                res += 1;
                res += num;
                res += divisor;
                res += num/divisor;
            }
        }
    }
}
