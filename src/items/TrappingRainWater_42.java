package items;

/**
 * @author hechuan
 */
public class TrappingRainWater_42 {

    /**
     * Two pointer.
     * 维护两个指针left和right来遍历数组，维护两个指针leftMax和rightMax分别记录左边和右边最大的柱值，每次比较当前左右两边的柱值，然后处理柱
     * 值小的那一边：
     * While left < right do:
     *     1.If height[left] < height[right]:
     *         If height[left] >= leftMax, update leftMax,
     *         Else res += leftMax−height[left].
     *         left++.
     *     2. Else
     *       If height[right] >= rightMax, update rightMax,
     *       Else res += right_max−height[right].
     *       right--.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param height input array
     * @return the water that we can trap
     */
    public int trap1(int[] height) {
        int res = 0, left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                }
                else {
                    res += leftMax-height[left];
                }
                left++;
            }
            else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                }
                else {
                    res += rightMax-height[right];
                }
                right--;
            }
        }

        return res;
    }

    /**
     * DP solution.
     *
     * 维护两个数组leftMax和rightMax，分别记录在当前柱值左右两边最大的柱值。
     * 然后遍历数组，每次去左右两边最小的比当前柱值大的元素，减去当前的柱值，即为蓄水量。
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param height input array
     * @return the water that we can trap
     */
    public int trap2(int[] height) {
        if (height.length == 0) { return 0; }

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];

        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        for (int i = height.length-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMax[i], rightMax[i])-height[i];
        }
        return res;
    }
}
