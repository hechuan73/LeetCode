package items;

/**
 * @author hechuan
 */
public class XOROperationInAnArray_1486 {

    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= (start + 2 * i);
        }

        return res;
    }
}
