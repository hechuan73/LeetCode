package items;

import algorithms.sort.MergeSort;
import algorithms.sort.QuickSort;

public class SortList_148 {

    /**
     * Approach: 使用非递归的归并排序
     *
     * 分析：由于题目要求排序时间复杂度需要在O(nlogn)，所以我们考虑快排和归并排序两种方法。而要求空间复杂度为O(1)，基于递归的方式，空间复杂度
     * 至少为O(logn)。此外，基于稳定性考虑，所以我们还是选择归并排序。由于基于数组的归并排序，在进行"并"操作时，空间复杂度为O(n)。而基于链表，
     * 在进行"并操作"时，不需要分配额外的空间，可以修改指针来改变节点顺序。同时，由于基于递归操作，空间复杂度至少为O(logn)（可以理解为函数栈），
     * 所以这里我们需要考虑迭代的方式。
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
    public ListNode sortList(ListNode head) {
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

    /**
     * Using recursive MergeSort for list.
     *
     * @param head input list head
     * @return the sorted list head
     */
    private ListNode sortList2(ListNode head) {
        return MergeSort.mergeSortListWithRecursive(head);
    }

    /**
     * Using recursive QuickSort for list.
     *
     * @param head input list head
     * @return the sorted list head
     */
    private ListNode sortList3(ListNode head) {
        return QuickSort.quickSortListWithRecursive(head);
    }
}
