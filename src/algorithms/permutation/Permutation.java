package algorithms.permutation;

import java.util.List;

/**
 * @author hechuan
 */
public class Permutation {

    /**
     * Permutation: permutations from a sorted array without repeat numbers.
     *
     * @param nums input sorted array without repeat number
     * @param tmp store each loop value
     * @param visited symbols of visited elements
     */
    public static void permutationWithoutRepeatNumber(int[] nums, List<Integer> tmp, boolean[] visited) {
        if (tmp.size() == nums.length) {
            for (int i : tmp) { System.out.print(i + " "); }
            System.out.println();
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) { continue; }
            tmp.add(nums[i]);
            visited[i] = true;
            permutationWithoutRepeatNumber(nums, tmp, visited);
            tmp.remove(tmp.size()-1);
            visited[i] = false;
        }
    }

    /**
     * Permutation: permutations from a sorted array with repeat numbers.
     *
     * @param nums input sorted array without repeat number
     * @param tmp store each loop value
     * @param visited symbols of visited elements
     */
    public static void permutationWithRepeatNumber(int[] nums, int length, List<Integer> tmp, boolean[] visited) {
        if (length == nums.length) {
            for (int i : tmp) { System.out.print(i + " "); }
            System.out.println();
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) { continue; }
            if (i > 0 && nums[i] == nums[i-1] && visited[i-1]) { continue; }
            tmp.add(nums[i]);
            visited[i] = true;
            permutationWithRepeatNumber(nums, length+1, tmp, visited);
            tmp.remove(tmp.size()-1);
            visited[i] = false;
        }
    }
}
