package items;

import java.util.ArrayList;

/**
 * @author hechuan
 */
public class TwentyFourGame_679 {

    public boolean judgePoint24(int[] nums) {
        ArrayList<Double> values = new ArrayList<>();
        for (int num : nums) {
            values.add((double) num);
        }

        return backtracking(values);
    }

    private boolean backtracking(ArrayList<Double> nums) {
        int size = nums.size();
        if (size == 0) { return false; }
        if (size == 1) { return Math.abs(nums.get(0)-24) < 1e-6; }

        ArrayList<Double> list;
        double[] cases;
        double a, b;
        // 每次都选择两张牌
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                a = nums.get(i);
                b = nums.get(j);
                // 这两张牌可能组合成的结果，由于double支持除数为0，其结果是无穷大，所以不用单独考虑
                cases = new double[] {a+b, a-b, b-a, a*b, a/b, b/a};

                // 将它们组合的每一种结果，和另外剩下的数字来做计算，依次递归下去
                for (double aCase : cases) {
                    list = new ArrayList<>();
                    list.add(aCase);
                    // 取剩下的数字
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) { list.add(nums.get(k)); }
                    }

                    // 回溯递归处理
                    if (backtracking(list)) { return true; }
                }
            }
        }

        return false;
    }
}
