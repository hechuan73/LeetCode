package items;

import java.util.Arrays;

/**
 * @author hechuan
 */
public class Heaters_475 {

    /**
     * Approach:
     * 1. find the minimum radius of the heater for each house.
     * 2. find the max radius of all radiuses for all the houses in step 1.
     *
     * @param houses house position array
     * @param heaters heater position array
     * @return the minimum radius of the heaters
     */
    public int findRadius(int[] houses, int[] heaters) {
        // the heaters array need to be sorted for binary search.
        Arrays.sort(heaters);

        int res = 0;
        for (int house : houses) {
            // if the value of the house is not find in heaters, it will return '-insertion-1'
            int index = Arrays.binarySearch(heaters, house);
            // 'index = 0' means there is a heater in the house position, the radius can be 0
            if (index < 0) {
                // for the non-negative num, -num = ~num+1, so -insertion-1 = ~num+1-1 = ~num, so we can find the
                // insertion index.
                index = ~index;
                // the distance from the left heater to the house. index = 0 means there is no left heater for the house.
                int distLeft = index > 0 ? house - heaters[index-1] : Integer.MAX_VALUE;
                // the distance from the right heater to the house. index = heaters.length means there is no right
                // heater for the house.
                int distRight = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

                // firstly find the minimum of left and right distance as the minimum radius for the house.
                // secondly find the maximum in all minimum radiuses as the result.
                res = Math.max(res, Math.min(distLeft, distRight));
            }
        }

        return res;
    }
}
