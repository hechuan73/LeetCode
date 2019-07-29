package items;

public class RemoveNthNodeFromEndOfList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        ListNode first = headNode;
        ListNode second = headNode;

        for (int i = 0; i <= n; i++) first = first.next;

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return headNode.next;
    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        List<ListNode> nodes = new ArrayList<>();
//        ListNode node = head;
//        while (node != null) {
//            nodes.add(node);
//            node = node.next;
//        }
//
//        if (n == nodes.size()) head = head.next;
//        else nodes.get(nodes.size() - n - 1).next = nodes.get(nodes.size() - n).next;
//
//        return head;
//    }
}
