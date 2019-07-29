package items;

public class SwapNodesInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        ListNode node = headNode, lastNode = headNode, lastLastNode = headNode, nodeNext;
        int count = -1;
        while (node != null) {
            count++;
            if (count != 0 && count % 2 == 0) {
                nodeNext = node.next;
                lastLastNode.next = node;
                node.next = lastNode;
                lastNode.next = nodeNext;
                node = nodeNext;
                count = 0;
            }
            else {
                lastLastNode = lastNode;
                lastNode = node;
                node = node.next;
            }
        }

        return headNode.next;
    }
}
