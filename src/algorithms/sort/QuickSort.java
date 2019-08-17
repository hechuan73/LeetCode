package algorithms.sort;

public class QuickSort {

    /**
     * 快速排序是一种 “自上而下” 的排序：
     * 如果排序数组a中下标从begin到end之间的一组数据，我们选择begin到end之间的任意一个数据作为pivot（分区点），遍历begin到end之间
     * 数据，将小于pivot的放到左边，将大于pivot的放到右边，将pivot放在中间。一次排序后，数组被分成三个部分，[begin, pivot-1]之间
     * 的数据是小于pivot的，[pivot+1, end]之间的数据是大于pivot的。
     *
     * 根据分治、递归思想，递归处理[begin, pivot-1]和[pivot+1, end]之间的数据，直到区间缩小为1，即说明所有数据都有序了。
     *
     * 最好时间复杂度：O(nlogn)
     * 最坏时间复杂度：O(n2)
     * 平均时间复杂度：O(nlogn)
     *
     * 空间复杂度：O(1)
     * 不稳定排序
     *
     * @param a input array
     * @param begin the begin index of sort
     * @param end the end index of sort
     */
    public static void quickSort(int[] a, int begin, int end) {
        if (begin >= end) { return;}

        int pivot = partition(a, begin, end);
        quickSort(a, begin, pivot-1);
        quickSort(a, pivot+1, end);
    }

    /**
     * 为了达到原地交换，空间复杂度为O(1)，我们通过游标index将数组分为两份，[begin, index-1]数据都是小于pivot的，[index+1, end]
     * 间的数据都是大于pivot的，我们每次将数组最后一个元素作为pivot，返回其下标index。
     *
     * @param a input array
     * @param begin the begin index of sort
     * @param end the end index of sort
     * @return the pivot index
     */
    private static int partition(int[] a, int begin, int end) {
        int index = begin;
        for (int i = begin; i <= end - 1; i++) {
            if (a[i] < a[end]) {
                int tmp = a[index];
                a[index++] = a[i];
                a[i] = tmp;
            }
        }

        int tmp = a[index];
        a[index] = a[end];
        a[end] = tmp;
        return index;
    }
}
