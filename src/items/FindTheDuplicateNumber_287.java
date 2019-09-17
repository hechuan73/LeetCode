package items;

public class FindTheDuplicateNumber_287 {

    /**
     * First off, we can easily show that the constraints of the problem imply that a cycle must exist. Because each
     * number in nums is between 1 and n, it will necessarily point to an index that exists. Therefore, the list can be
     * traversed infinitely, which implies that there is a cycle. And we need to find the entrance which is the duplicate
     * element.
     *
     * For example: for the array A = [2, 6, 4, 1, 3, 1, 5],
     * index: 0, 1, 2, 3, 4, 5, 6
     * value: 2, 6, 4, 1, 3, 1, 5
     *
     * So this array can transfer to a cycle list: 0 -> 2 -> 4 -> 3 -> [1 -> 6 -> 5 -> 1] (cycle list)
     * Moreover, 'slow = nums[slow]' means the pointer 'slow' runs one step every time, and the 'fast = nums[nums[fast]]'
     * means the pointer 'fast' runs two steps every time. So we need to find the entrance of the cycle as duplicate
     * element.
     *
     * @param nums input array
     * @return the duplicate element
     */
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        // find the intersection of the two pointers.
        do {
            // run two steps
            fast = nums[nums[fast]];
            // run one step
            slow = nums[slow];
        } while (fast != slow);

        // reset the slow one to find the entrance of the cycle list.
        slow = nums[0];
        while (slow != fast) {
            // both of the two pointers run one step every time.
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
