package items;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hechuan
 */
public class NAryTreePreorderTraversal_589 {

    /**
     * DFS.
     *
     * @param root the root node of the N_Ary tree
     * @return the preorder traversal list
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            for (Node child : root.children) { dfs(child, res); }
        }
    }

    /**
     * BFS.
     *
     * @param root the root node of the N_Ary tree
     * @return the preorder traversal list
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) { return res; }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node curr;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            res.add(curr.val);
            for (int i = curr.children.size() - 1; i >= 0; i--) {
                stack.push(curr.children.get(i));
            }
        }

        return res;
    }

}
