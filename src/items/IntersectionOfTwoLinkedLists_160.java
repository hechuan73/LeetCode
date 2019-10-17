package items;

/**
 * @author hechuan
 */
public class IntersectionOfTwoLinkedLists_160 {

    /**
     * Approach: 利用两个指针，各自开始遍历两条链表，当遍历到头时，跳到另一条链表的头部继续遍历。当两者相遇时，所在的节点即为相交点。因为两条
     * 链表的的总长度是相同的，所以它们会在相交点处相遇。
     *
     * 记录两条链表的最后一个节点，如果两者相交，则最后一个节点必然相同；如果不相交，则不同。
     *
     * @param headA the head of list A.
     * @param headB the head of list B.
     * @return the insertion node.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (!(headA != null && headB != null)) { return null; }

        ListNode nodeA = headA, nodeB = headB;
        ListNode lastNodeA = null, lastNodeB = null;

        while (nodeA != nodeB) {
            if (lastNodeA != null && lastNodeB != null && lastNodeA != lastNodeB) { return null; }
            if (nodeA.next == null) {
                lastNodeA = nodeA;
                nodeA = headB;
            }
            else { nodeA = nodeA.next; }

            if (nodeB.next == null) {
                lastNodeB = nodeB;
                nodeB = headA;
            }
            else { nodeB = nodeB.next; }
        }

        return nodeA;
    }
}
