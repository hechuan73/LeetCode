package Items;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedListII_92 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(0);
        ListNode start = fakeHead, end = null;
        fakeHead.next = head;
        List<ListNode> nodes = new ArrayList<>();

        int i = 1;
        while (i <= n+1 && head != null) {
            if (i == n+1) end = head;
            else if (i >= m) nodes.add(head);
            else if (i == m-1) start = head;

            head = head.next;
            i++;
        }

        int count = nodes.size();
        for (int j = count-1; j > 0; j--) nodes.get(j).next = nodes.get(j-1);

        start.next = nodes.get(count-1);
        nodes.get(0).next = end;
        return fakeHead.next;
    }
}
