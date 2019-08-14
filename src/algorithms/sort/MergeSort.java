package algorithms.sort;

public class MergeSort {

    /**
     * 归并排序是一种 “自下而上” 的排序：
     * 如果要排序一个数组，先把数组从中间分成前后两部分，然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有
     * 序了。
     *
     * 归：不断递归将大的排序问题分解为前后两个小的部分的排序问题。
     * 并：将两个排好序的小的部分，合并为一个大的有序的部分。
     *
     * 最好时间复杂度：O(nlogn)
     * 最坏时间复杂度：O(nlogn)
     * 平均时间复杂度：O(nlogn)
     *
     * 空间复杂度：O(n)
     * 稳定排序
     *
     * @param a input array
     * @param begin the begin index of sort
     * @param end the end index of sort
     */
    public static void mergeSort(int[] a, int begin, int end) {
        if (begin >= end) return;

        int mid = (begin+end)/2;
        mergeSort(a, begin, mid);
        mergeSort(a, mid+1, end);
        merge(a, begin, mid, end);
    }

    private static void merge(int[] a, int begin, int mid, int end) {
         int[] tmp = new int[end-begin+1];
         int i = begin, j = mid+1, k = 0;

         // merge data to array tmp
         while (i <= mid && j <= end) {
             if (a[i] <= a[j]) tmp[k++] = a[i++];
             else tmp[k++] = a[j++];
         }

         // check if there is remain data in the two parts a[begin, mid] and a[mid+1, end]
         int start = i, stop = mid;
         if (j <= end) {
             start = j;
             stop = end;
         }

         // copy the remain data to tmp
         while (start <= stop) tmp[k++] = a[start++];
         // copy data from array tmp to array a.
         if (tmp.length >= 0) System.arraycopy(tmp, 0, a, begin, tmp.length);
    }
}
