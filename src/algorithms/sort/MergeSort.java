package algorithms.sort;

import items.ListNode;

/**
 * @author hechuan
 */
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
        if (begin >= end) { return; }

        int mid = (begin+end)/2;
        mergeSort(a, begin, mid);
        mergeSort(a, mid+1, end);
        //merge(a, begin, mid, end);
        mergeWithPlaceHolder(a, begin, mid, end);
    }

    private static void merge(int[] a, int begin, int mid, int end) {
         int[] tmp = new int[end-begin+1];
         int i = begin, j = mid+1, k = 0;

         // merge data to array tmp
         while (i <= mid && j <= end) {
             if (a[i] <= a[j]) { tmp[k++] = a[i++]; }
             else { tmp[k++] = a[j++]; }
         }

         // check if there is remain data in the two parts a[begin, mid] and a[mid+1, end]
         int start = i, stop = mid;
         if (j <= end) {
             start = j;
             stop = end;
         }

         // copy the remain data to tmp
         while (start <= stop) { tmp[k++] = a[start++];}
         // copy data from array tmp to array a.
         if (tmp.length >= 0) {System.arraycopy(tmp, 0, a, begin, tmp.length);}
    }

    private static void mergeWithPlaceHolder(int[] a, int begin, int mid, int end) {

        // last element is placeholder
        int[] left = new int[mid-begin+2];
        // last element is placeholder
        int[] right = new int[end-mid+1];

        System.arraycopy(a, begin, left, 0, mid-begin+1);
        System.arraycopy(a, mid+1, right, 0, end-mid);

        // add two placeholders
        left[mid-begin+1] = Integer.MAX_VALUE;
        right[end-mid] = Integer.MAX_VALUE;

        int i = 0, j = 0, k = begin;
        // merge data to array a
        while (k <= end) {
            if (left[i] <= right[j]) { a[k++] = left[i++]; }
            else { a[k++] = right[j++]; }
        }
    }

    /**
     * Recursive MergeSort for list
     *
     * @param head input list head
     * @return the sorted list head
     */
    public static ListNode mergeSortListWithRecursive(ListNode head) {
        if (null == head || null == head.next) { return head; }

        // fast = head.next is to avoid endless loop when there are only two nodes.
        ListNode slow = head, fast = head.next;

        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode next = slow.next;
        slow.next = null;

        ListNode left = mergeSortListWithRecursive(head);
        ListNode right = mergeSortListWithRecursive(next);

        ListNode fakeHead = new ListNode(0);
        ListNode prev = fakeHead;

        while (null != left && null != right) {
            if (left.val <= right.val) {
                prev.next = left;
                left = left.next;
            }
            else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }

        prev.next = left == null ? right : left;

        return fakeHead.next;
    }

    /**
     * 非递归的归并排序
     *
     * Time Complexity: O(nlogn)
     * Space Complexity: O(1)
     *
     * 在迭代的方式中，由于递归是通过二分来找到链表的最小节点单元，我们这里直接从底向上进行"并"操作：
     * 1. 第一次，即将整个链表切分为多个长度为1的单元，并按顺序两两排序合并，合并完成的已排序单元长度为2；
     * 2. 第二次，即将整个链表切分为多个长度为2的单元，并按顺序两两排序合并，合并完成的已排序单元长度为4；
     * 以此类推，直到单元长度为n/2，即最后一次合并两个最大的链表。
     *
     * 例如：[3, 45, 2, 15, 37, 19, 39, 20]
     *           progress              step size                        sublists                              merged
     * [3, 45, 2, 15, 37, 19, 39, 20]      1	 [[3], [45], [2], [15], [37], [19], [39], [20]]   [[3, 45], [2, 15], [19, 37], [20, 39]]
     * [3, 45, 2, 15, 19, 37, 20, 39]	   2     [[3, 45], [2, 15], [19, 37], [20, 39]]           [[2, 3, 15, 45], [19, 20, 37, 39]]
     * [2, 3, 15, 45, 19, 20, 37, 39]	   4	 [[2, 3, 15, 45], [19, 20, 37, 39]]               [2, 3, 15, 19, 20, 37, 39, 45]
     *
     * 注意:
     *     1. 我们将子链表存入数组中，每一个子链表最后一个节点tail.next需要置为null，以将所有子链表分隔开。
     *     2. 判断是为完成时，是看最开始的两个子链表是否包含所有的元素，而不仅仅是每一个划子链表是否还有剩余元素，所以用了"&="操作。
     *     3. 在对子链表进行合并后，需要将prev指针移到最后一个节点，以便于后面的链表合并进来。
     *
     * Time Complexity: O(nlogn)
     * Space Complexity: O(1)
     *
     * @param head input list.
     * @return the head of the sorted list.
     */
    public static ListNode sortList(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode[] list = new ListNode[2];
        boolean done = (null == head);
        ListNode prev, remaining, tail;
        for (int step = 1; !done; step *= 2) {
            // init three pointers
            done = true;
            prev = fakeHead;
            remaining = prev.next;

            do {
                // split off two sublists of each step size
                for (int i = 0; i < list.length; i++) {
                    list[i] = remaining;
                    // init tail pointer.
                    tail = null;
                    for (int j = 0; j < step && remaining != null; j++) {
                        tail = remaining;
                        remaining = remaining.next;
                    }

                    // terminate the sublist.
                    if (null != tail) { tail.next = null; }
                }

                // we are done if the first two sublists in this pass contain the entire original list.
                done &= (null == remaining);

                // merge the two sublists into one list.
                int index = 0;
                while (null != list[0] && null != list[1]) {
                    index = list[0].val <= list[1].val ? 0 : 1;
                    prev.next = list[index];
                    list[index] = list[index].next;
                    prev = prev.next;
                }

                if (null == list[0]) { prev.next = list[1]; }
                else { prev.next = list[0];}

                // move the prev pointer to the last node for next pass insertion.
                while (prev.next != null) { prev = prev.next; }

            } while (null != remaining);
        }

        return fakeHead.next;
    }
}
