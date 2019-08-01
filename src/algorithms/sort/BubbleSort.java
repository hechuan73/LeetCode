package algorithms.sort;

public class BubbleSort {

    /**
     * 每次冒泡都会对相邻的两个元素进行比较，看是否满足大小关系要求，如果不满足就让它俩互换，依次冒泡会让至少一个元素移动到它应该在
     * 的位置，重复n次，就完成了n个数据的排序工作。
     *
     * 最好时间复杂度：O(n)  原数组有序（有序度最大）
     * 最坏时间复杂度：O(n2) 原数组无序（无序度最大）
     * 平均时间复杂度：O(n2)
     *
     * 空间复杂度：O(1)
     *
     * @param a input array
     */
    public static void bubbleSort(int[] a) {
        if (a.length <= 1) return;

        for (int i = 0; i < a.length; i++) {
            boolean flag = false;
            for (int j = 0; j < a.length-i-1; j++) {
                if (a[j+1] < a[j]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }
}
