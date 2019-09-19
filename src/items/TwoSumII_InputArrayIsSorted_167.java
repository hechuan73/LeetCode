package items;

/**
 * @author hechuan
 */
public class TwoSumII_InputArrayIsSorted_167 {

    /**
     * Approach 1: use two pointers.
     *     Time Complexity: O(n)
     *
     * Approach 2: use binary search. we first get an element[i], and binary search the other one in [i+1, n].
     *     Time Complexity: O(nlog(n))
     *
     * @param numbers input array
     * @param target target value
     * @return the indexes
     */
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) { return new int[] {low+1, high+1}; }
            else if (sum > target) { high--;}
            else { low++;}
        }

        return new int[] {-1, -1};
    }
}
