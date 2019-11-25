package items;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author hechuan
 */
public class NAryTreePostorderTraversal_590 {

    /**
     * DFS.
     *
     * @param root the root node of the N_Ary tree
     * @return the postorder traversal list
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node root, List<Integer> res) {
        if (root != null) {
            for (Node child : root.children) { dfs(child, res); }
            res.add(root.val);
        }
    }


    /**
     * Iterative with reversal traversing from right to left and then reverse the result list.
     * Tip: use LinkedList.addFirst() to simplify the reversing operation.
     *
     * @param root the root node of the N_Ary tree
     * @return the postorder traversal list
     */
    public List<Integer> postorder2(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) { return res; }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node curr;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            res.addFirst(curr.val);
            for (Node child : curr.children) { stack.push(child); }
        }

        return res;
    }

    /**
     * Iterative with two stacks.
     *
     * @param root the root node of the N_Ary tree
     * @return the postorder traversal list
     */
    public List<Integer> postorder3(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) { return res; }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        Node curr;
        while (!stack1.isEmpty()) {
            curr = stack1.pop();
            stack2.push(curr);
            for (Node child : curr.children) { stack1.push(child); }
        }

        while (!stack2.isEmpty()) { res.add(stack2.pop().val); }

        return res;
    }
}
