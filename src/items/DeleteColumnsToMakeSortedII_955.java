package items;

/**
 * @author hechuan
 */
public class DeleteColumnsToMakeSortedII_955 {

    /**
     * 这题的思路就是从所有单词的第一列开始，遍历每一列字母，检查当前列是否合法。那么我们分两种情况讨论
     * 1. 不合法：当前列一旦出现某一行的字母顺序大于后一行，当前列即为不合法列，那么我们就需要删除整列，result++。
     * 2. 合法：如果当前列遍历到最后一行都没有发现不合法的行，说明当前列只会存在前一行小于或等于后一行的情况，这个时候我们就需要用greedy的思想
     *         找到所有"sorted"的行并且进行标记（所谓"sorted"的行就是指前一行的字母顺序小于后一行）。那么剩下来未标记行就是在当前列拥有相同
     *         字母关系的很多pair，对于这些行，我们就要检查他们后面一列的字母关系。这样以后凡是在已经标记sorted的行，我们在之后的iterations
     *         都可以skip，只需要检查未sorted的行就可以。
     *
     * @param A input string array
     * @return the minimum deletion size
     */
    public int minDeletionSize(String[] A) {
        int res = 0;
        boolean[] sorted = new boolean[A.length-1];
        int j;
        for (int i = 0; i < A[0].length(); i++) {
            for (j = 0; j < A.length-1; j++) {
                // 如果该行已经是sorted，则不需要再比较了
                if (!sorted[j] && A[j].charAt(i) > A[j+1].charAt(i)) {
                    res++;
                    break;
                }
            }

            if (j < A.length-1) { continue; }

            // 标记该行是否是sorted
            for (int k = 0; k < A.length - 1; k++) {
                if (A[k].charAt(i) < A[k+1].charAt(i)) {
                    sorted[k] = true;
                }
            }
        }

        return res;
    }
}
