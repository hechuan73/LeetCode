package items;

/**
 * @author hechuan
 */
public class CustomStack_1381 {

    private final int[] data;
    private int index = 0;

    public CustomStack_1381(int maxSize) {
        data = new int[maxSize];
        index = 0;
    }

    public void push(int x) {
        if (index < data.length) { data[index++] = x; }
    }

    public int pop() {
        if (index <= 0) { return -1; }
        else {
            int res = data[--index];
            data[index] = 0;
            return res;
        }
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i < index; i++) {
            data[i] += val;
        }
    }
}
