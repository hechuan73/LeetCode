package items;

/**
 * @author hechuan
 */
public class BulbSwitcherIV_1529 {

    public int minFlips(String target) {
        int res = 0;
        char[] chars = target.toCharArray();
        // 从左到右依次判断是否需要拨开关，由于只有两种状态，拨奇数次为开，偶数次为关
        // 依次判断每一位
        for (char cha : chars) {
            // 将字符转换成数字
            if ((res & 1) != (cha - 48)) {
                res++;
            }
        }

        return res;
    }
}
