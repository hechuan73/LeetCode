package items;

/**
 * @author hechuan
 */
public class ProductOfArrayExceptSelf_238 {

    /**
     * Simple method with 2 arrays which represent left and right product, and then multiply them with corresponding index.
     *
     * @param nums input array
     * @return the product except self
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        right[nums.length-1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }

    /**
     * Improved method with the input array and one variable which represent left and right product, and then multiply them with corresponding index.
     *
     * @param nums input array
     * @return the product except self
     */
    public int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = 1;
        // from left to right
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        // from right to left, use a variable to store the product
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *=  right;
            right *= nums[i];
        }

        return res;
    }
}
