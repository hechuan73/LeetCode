package items;

/**
 * @author hechuan
 */
public class CarPooling_1094 {

    /**
     * The amount of people of each trip/station is adding the picking-up numbers and subtracting dropping-off numbers,
     * so we can calculating the amount of people of each station, and then traversing all stations with initial
     * capacity. In each station, the remain capacity is 'capacity - stopPassengerNum', if the value is negative, which
     * means there is no sufficient seats for all passengers in this station, we return false. If the value is
     * non-negative, then moving on.
     *
     * @param trips input trips array
     * @param capacity initial capacity of the car
     * @return if the car can move all people to their destination.
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stopPassengerNums = new int[1001];
        for (int[] trip : trips) {
            stopPassengerNums[trip[1]] += trip[0];
            stopPassengerNums[trip[2]] -= trip[0];
        }

        for (int stopPassengerNum : stopPassengerNums) {
            capacity -= stopPassengerNum;
            if (capacity < 0) { return false; }
        }

        return true;
    }
}
