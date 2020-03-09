package items;

/**
 * @author hechuan
 */
public class ClosestDivisors_1362 {

    public int[] closestDivisors(int num) {
        int target = num+2, product;
        int start = (int) Math.sqrt(target), end = start;

        while (start > 0 && end <= target && start <= end) {
            product = start*end;
            if (product == target || product == target-1) { return new int[]{start, end}; }
            if (product < target) { end++; }
            if (product > target) {start--; }
        }

        return new int[] {0, 0};
    }
}
