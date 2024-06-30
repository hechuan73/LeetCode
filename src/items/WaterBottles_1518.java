package items;

/**
 * @author hechuan
 */
public class WaterBottles_1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0;
        int empty = 0;
        while (numBottles != 0) {
            res += numBottles;
            empty += numBottles;
            numBottles = empty / numExchange;
            empty = empty % numExchange;
        }

        return res;
    }
}
