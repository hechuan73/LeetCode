package algorithms.sort;

public class InsertionSort {

    /**
     * 分为有序和无序两个区间。初始有序区间最开始只有一个元素，就是数组第一个元素。每次取无序区间的一个元素，在有序区间中找到合适的
     * 位置插入，保证有序的区间一直有序。
     *
     * 最好时间复杂度：O(n)  原数组有序（有序度最大）
     * 最坏时间复杂度：O(n2) 原数组无序（无序度最大）
     * 平均时间复杂度：O(n2)
     *
     * 空间复杂度：O(1)
     *
     * @param a input array
     */
    public static void insertionSort(int[] a) {

        if (a.length <= 1) return;

        for (int i = 1; i < a.length; i++) {
            int value = a[i];

            int j = i-1;
            for (; j >= 0; j--) {
                if (a[j] > value) a[j+1] = a[j];
                else break;
            }

            a[j+1] = value;
        }
    }
}
