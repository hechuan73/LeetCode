package Items;

public class RemoveElement_27 {

    public static int removeElement(int[] nums, int val) {
        int length = 0, tmp;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                length++;
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != val) {
                    tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    length++;
                    break;
                }
            }
        }

        return length;
    }
}
