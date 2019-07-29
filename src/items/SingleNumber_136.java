package items;


public class SingleNumber_136 {

    /**
     * Exclusive Or (XOR), its algorithms:
     * 1. a ^ 0 = a
     * 2. a ^ a = 0
     * 3. a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b.
     *
     * @param nums input nums
     * @return the single number
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) result ^= num;

        return result;
    }
}
