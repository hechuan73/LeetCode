package items;

public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = lastPos; i >= 0 ; i--)
            if (nums[i] >= lastPos - i) lastPos = i;

        return lastPos == 0;
    }
}
