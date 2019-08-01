package items;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber_202 {

    List<Integer> nums = new ArrayList<>();
    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (nums.contains(n)) return false; // check if there is a loop.
        nums.add(n);

        int sum = 0;
        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }

        return isHappy(sum);
    }
}
