package items;

/**
 * @author hechuan
 */
public class HowManyNumbersAreSmallerThanTheCurrentNumber_1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counter = new int[101];
        for (int num : nums) { counter[num]++; }

        int[] res = new int[nums.length];
        int count;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = nums[i]-1; j >= 0; j--) {
                count += counter[j];
            }
            res[i] = count;
        }
        return res;
    }
}
