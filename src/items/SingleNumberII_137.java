package items;

public class SingleNumberII_137 {

    /**
     * 通用解法：给定一个数组，其中只有一个数出现1次，其余数出现k次，求这个数。
     *
     * 考虑到每一个int类型的数都是32位的二进制数，对于所有数，每一位的二进制数0或1逐位累加之后，统计所得0或1的个数必然是3N或者3N+1。当统计1的
     * 个数时，3N表示待求数在该位没有贡献（该位为0），3N+1表示待求数在该位有贡献（该位为1），这样逐步得出每一位即可求得该数。
     *
     * 解法中，我们由低到高统计32位的每一位，所以mask从1开始，每次左移一位，并分别与所有数相与，结果为1表示该数字此位为，否则为0，以此统计每一
     * 位为1的个数。统计完后，我们需要将统计结果对3取余，再对每一位进行按位或'|'操作，即可逐步补全待求数的每一位。
     *
     * @param nums input array
     * @return the single number
     */
    public int singleNumber1 (int[] nums) {
        int res = 0;
        int k = 3;
        for (int i = 0; i < k; i++) {
            int mask = 1 << i;
            int count = 0;
            for (int num : nums) {
                if ((num & mask) != 0) {count++;}
            }

            if (count % 3 != 0) {res |= mask;}
        }

        return res;
    }

    /**
     * 此题其实是考虑一个逻辑电路的设计问题，或者说是不进位加法设计问题：
     * 一个数出现1次为1，出现两次为2，出现三次需要能够自动抵消为0，最后剩下的即为出现一次的数。
     *
     * 首先：一个二进制为只能表示0和1，天生可以记录一个数出现了一次还是两次：
     *      x ^ 0 = x;    x ^ x = 0
     * 其次：要记录出现三次，需要两个进制位才能表示，我们取两个变量：
     *      ab ^ 00 = ab;   ab ^ ab = 0;
     * 这里，a、b都是32位的变量。我们使用a的第k位与b的第k位组合起来的两位二进制，表示当前位出现了几次。也就是，一个8位的二进制x就变成了16位来
     * 表示: x = x[7] x[6] x[5] x[4] x[3] x[2] x[1] x[0]
     * 变成：x = (a[7]b[7]) (a[6]b[6]) ... (a[1]b[1]) (a[0]b[0])
     *
     * 它是一个逻辑电路，a、b变量中，相同位置上，分别取出一位，负责完成00->01->10->00，当数字出现3次时置零。
     *
     * 代码中：one为1表示该数字出现一次，two为1表示该数字出现2次，three为1表示该数字出现3次。当three为1时，需要将one和two清0。
     *
     * @param nums input array
     * @return the single number
     */
    public int singleNumber2 (int[] nums) {
        int one = 0, two = 0, three;
        for (int num : nums) {
            // two为1，表示该数出现两次，之所以先计算two，是因为如果先计算one，异或后结果并不会进位，如果出现两次会被清0。
            two |= (one ^ num);
            // one为1，表示该数出现1次。
            one ^= num;
            // two和one均为1，表示出现3次，即three为1
            three = one & two;
            // 当three为1，即出现3次时，需要将one和two清0。因为当three是由one和two计算而来，如果three为1，则one和two也为1。所以对three
            // 按位取反～，再分别与两者相与。如果three=1，～three=0，则one和two被置0；three为0，～three为1，则one和two不变。
            one &= ~three;
            two &= ~three;
        }
        return one;
    }

    /**
     * 根据解法二继续化简：
     * 假设有一个数为x,那么则有如下规律：
     *      0 ^ x = x,
     *      x ^ x = 0；
     *      x & ~x = 0,
     *      x & ~0 =x;
     *
     * 一开始a = 0, b = 0;
     * x第一次出现: a = (a ^ x) & ~b的结果为 a = x， b = (b ^ x) & ~a的结果为此时因为a = x了，所以b = 0;
     * x第二次出现: a = (a ^ x) & ~b，a = (x ^ x) & ~0，a = 0; b = (b ^ x) & ~a 化简，b = (0 ^ x) & ~0 ,b = x;
     * x第三次出现: a = (a ^ x) & ~b，a = (0 ^ x) & ~x，a = 0; b = (b ^ x) & ~a 化简，b = (x ^ x) & ~0 , b = 0;所以出现三次同
     *            一个数，a和b最终都变回了0.
     *
     * 只出现一次的数，按照上面x第一次出现的规律可知a = x, b = 0;因此最后返回a.
     *
     * @param nums input array
     * @return the single number
     */
    public int singleNumber3 (int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }

        return a;
    }

}
