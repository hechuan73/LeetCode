package algorithms.combination;

import java.util.List;

/**
 * @author hechuan
 */
public class Combination {

    /**
     * Combination: choose m numbers from a sorted array without repeat numbers.
     *
     * @param nums input sorted array without repeat number
     * @param m numbers to choose
     * @param start start index
     * @param tmp store each loop value
     */
    private static void combinationWithoutRepeatNumber(int[] nums, int m, int start, List<Integer> tmp) {
        if (m == 0) {
            for (int i : tmp) { System.out.print(i + " "); }
            System.out.println();
            return;
        }

        for (int i = start; i < nums.length-m+1; i++) {
            tmp.add(nums[i]);
            combinationWithoutRepeatNumber(nums, m-1, i+1, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    /**
     * Combination: choose m numbers from a sorted array with repeat numbers.
     *
     * @param nums input sorted array with repeat number
     * @param m numbers to choose
     * @param start start index
     * @param tmp store each loop value
     */
    public static void combinationWithRepeatNumber(int[] nums, int m, int start, List<Integer> tmp) {
        if (m == 0) {
            for (int i : tmp) { System.out.print(i + " "); }
            System.out.println();
            return;
        }

        for (int i = start; i < nums.length-m+1; i++) {
            if (i > 0 && nums[i] == nums[i-1]) { continue; }
            tmp.add(nums[i]);
            combinationWithRepeatNumber(nums, m-1, i+1, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
