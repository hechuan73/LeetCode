package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class ProductOfNumbers_1352 {

    List<Integer> values;
    int[] cache;
    int last;
    public ProductOfNumbers_1352() {
        values = new ArrayList<>();
        cache = new int[40001];
        last = -1;
        cache[0] = 1;
    }

    public void add(int num) {
        for (int i = last; i >= 0; i--) {
            cache[i+1] = cache[i] * num;
        }
        cache[0] = num;
        last++;
    }

    public int getProduct(int k) {
        return cache[k-1];
    }
}
