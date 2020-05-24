package items;

/**
 * @author hechuan
 */
public class CheckIfAllOnesAreAtLeastLengthKPlacesAway_1437 {

    public boolean kLengthApart(int[] nums, int k) {
        int lastOneIndex = -k-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i - lastOneIndex - 1 < k) { return false; }
                else { lastOneIndex = i; }
            }
        }

        return true;
    }
}
