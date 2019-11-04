package items;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hechuan
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) { return res; }
        Stack<TreeNode> currLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();

        currLevel.push(root);
        boolean oddLevel = true;
        TreeNode curr;
        List<Integer> subList;
        while(!currLevel.isEmpty()) {
            subList = new ArrayList<>();
            while (!currLevel.isEmpty()) {
                curr = currLevel.pop();
                if (oddLevel) {
                    if (curr.left != null) { nextLevel.push(curr.left); }
                    if (curr.right != null) { nextLevel.push(curr.right); }
                }
                else {
                    if (curr.right != null) { nextLevel.push(curr.right); }
                    if (curr.left != null) { nextLevel.push(curr.left); }
                }
                subList.add(curr.val);
            }

            res.add(subList);
            oddLevel = !oddLevel;
            currLevel = nextLevel;
            nextLevel = new Stack<>();
        }

        return res;
    }
}
