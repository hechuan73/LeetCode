package items;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList_1019 {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }

        int[] res = new int[nodes.size()];
        Stack<Integer> stack = new Stack<>();

        // general template.
        //for (int i = nodes.size()-1; i >= 0 ; i--) {
        //    while (!stack.isEmpty() && stack.peek() <= nodes.get(i)) {
        //        stack.pop();
        //    }
        //    res[i] = stack.isEmpty() ? 0 : stack.peek();
        //    stack.push(nodes.get(i));
        //}

        // optimize version when the default value is 0 (no next greater element)
        for (int i = 0; i < nodes.size(); i++) {
            while (!stack.isEmpty() && nodes.get(stack.peek()) < nodes.get(i)) {
                res[stack.pop()] = nodes.get(i);
            }
            stack.push(i);
        }

        return res;
    }
}
