package items;

/**
 * @author hechuan
 */
public class DistanceBetweenBusStops_1184 {

    public int distanceBetweenBusStops1(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;;
        }

        int res = 0, total = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                res += distance[i];
            }
            total += distance[i];
        }
        return Math.min(res, total - res);
    }

    public static int distanceBetweenBusStops2(int[] distance, int start, int destination) {
        int index = start;
        int distance1 = 0;
        // clockwise
        do {
            distance1 += distance[index];
            index = (index+1) % distance.length;
        } while (index == destination);

        int distance2 = 0;
        index = start;
        // counterclockwise
        do {
            index = index == 0 ? distance.length-1 : index-1;
            distance2 += distance[index];
        } while (index == destination);

        return Math.min(distance1, distance2);
    }
}
