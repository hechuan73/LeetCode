package items;

/**
 * @author hechuan
 */
public class SquaresOfaSortedArray_977 {

    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int left = 0, right = A.length-1;
        int index = A.length-1;

        while (left <= right) {
            int leftValue = A[left]*A[left];
            int rightValue = A[right]*A[right];
            if (leftValue > rightValue) {
                res[index--] = leftValue;
                left++;
            }
            else {
                res[index--] = rightValue;
                right--;
            }
        }

        return res;
    }
}
