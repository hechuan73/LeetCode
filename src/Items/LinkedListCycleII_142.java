package Items;

public class LinkedListCycleII_142 {

    /**
     * 方法主要分为两个阶段：
     * 1. 利用两个速度不同的指针(一个步长为1，一个步长为2)，来判断是否是否有环；
     * 2. 如果有环，再找出环的起点。
     *
     * 我们假设F个节点后，开始出现环，当slow节点走过F个节点，到达环的起点f时，fast节点处在节点h(与节点的f距离设为a);
     * 假设环的周长为C，那么环的另一半长度为b(b=C-a)。
     * 当出现环，两者第一次相遇时，有公式：
     *      2(F+a) = F + a + nC (n=1,2,3...)   ==>   F = nC - a (n=1,2,3...) ==> F = (n-1)C + b  (n=1,2,3...)
     * 所以，当出现环后，我们将slow节点重置为起始节点，同时将两者的步长置为1，当两者再次相遇时，slow节点走过距离F，到达环的起点f，fast节点
     * 则走过距离(n-1)C + b  (n=1,2,3...)，到达节点f，而节点f即为环的起始点。
     * @param head the head node
     * @return the start node of the cycle
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }

        return null;
    }
}
