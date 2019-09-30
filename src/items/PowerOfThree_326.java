package items;

/**
 * Approach 1: loop or recursive method.
 * Time Complexity: O(log3(n))
 * Space Complexity: O(1)
 *
 * Approach 2: Use the maximum int power value to calculate.
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 *
 * @author hechuan
 */
public class PowerOfThree_326 {

    public boolean isPowerOfThree(int n) {
        // get the maximum int power value of n (here is 3).
        // int maxIntPowerOfThree = (int) Math.pow(3, (int) (Math.log(Integer.MAX_VALUE)/Math.log(3)));
        // the maximum int power of 3 is 1162261467.
        int maxIntPowerOfThree = 1162261467;
        return (n > 0) && (maxIntPowerOfThree % n == 0);
    }
}
