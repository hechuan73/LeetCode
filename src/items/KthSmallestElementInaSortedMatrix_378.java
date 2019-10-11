package items;

/**
 * @author hechuan
 */
public class KthSmallestElementInaSortedMatrix_378 {

    /**
     * 这里我们使用的二分法，不再根据数组下标索引，而是根据具体的元素值，因为该数组在每一列和每一行都是有序的。
     *
     * 1. 找出二维矩阵中最小的数left，最大的数right，那么第k小的数必定在left~right之间；
     * 2. mid=(left+right) / 2；在二维矩阵中寻找小于等于mid的元素个数count；
     * 3. 若这个count小于k，表明第k小的数在右半部分且不包含mid，即left=mid+1, right=right，又保证了第k小的数在left~right之间；
     * 4. 若这个count大于k，表明第k小的数在左半部分且可能包含mid，即left=left, right=mid，又保证了第k小的数在left~right之间；
     * 5. 因为每次循环中都保证了第k小的数在left~right之间，当left==right时，第k小的数即被找出，等于right
     *
     * @param matrix input matrix
     * @param k the order k
     * @return the kth smallest number
     */
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0], high = matrix[matrix.length-1][matrix[0].length-1];

        while (low < high) {
            int mid = low + ((high-low)>>1);
            int row = 0, column = matrix[0].length-1;
            int count = 0;
            // 这里我们从第一行最后一个元素往回比较，每一次更新了mid，我们都需要从新计算一遍count。
            while (row < matrix.length && column >= 0) {
                // 当 matrix[row][column] <= mid 时，其左边的元素必定都比mid小，所以这一行不用再比较了
                if (matrix[row][column] <= mid ) {
                    count += column+1;
                    row++;
                }
                else {
                    // 往左边退一格
                    column--; }
            }

            if (count < k) { low = mid + 1; }
            else { high = mid; }
        }

        return high;
    }
}
