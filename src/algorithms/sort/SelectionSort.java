package algorithms.sort;

public class SelectionSort {

    /**
     * 分为有序和无序两个区间，每次从无序的区间中找出最小（大）的，放在有序区间的末尾
     *
     * 最好时间复杂度：O(n2) 原数组有序（有序度最大）
     * 最坏时间复杂度：O(n2) 原数组无序（无序度最大）
     * 平均时间复杂度：O(n2)
     *
     * 空间复杂度：O(1)
     *
     * @param a input array
     */
    public static void selectionSort(int[] a) {

        if (a.length <= 1) return;

        for (int i = 0; i < a.length-1; i++) {
            int min = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[min])
                    min = j;
            }

            if (min != i) {
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }
}
