package items;

/**
 * @author hechuan
 */
public class SearchA2DMatrix_74 {

    /**
     * Binary search with treating the matrix as a sorted list.
     *
     * @param matrix input matrix
     * @param target the target value
     * @return whether the target value is in the matrix
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) { return false; }
        int row = matrix.length, col = matrix[0].length;
        int start = 0, end = row*col-1, mid;

        while (start <= end) {
            mid = ((end-start)>>1) + start;
            // mid/col -> determine the row, mid%col -> determine the column.
            if (matrix[mid/col][mid%col] == target) {
                return true;
            }
            else if (matrix[mid/col][mid%col] > target) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return false;
    }
}
