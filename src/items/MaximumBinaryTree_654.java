package items;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hechuan
 */
public class MaximumBinaryTree_654 {


    /**
     * Using stack to find the maximum number in O(1)
     *
     * Each node went into stack once, and went out stack once. Worst case time complexity O(N).
     *
     * Time Complexity: O(n)
     * Space complexity: O(n)
     *
     * @param nums input array
     * @return the root of constructed tree
     */
    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode curr;
        for (int i = 0; i < nums.length; i++) {
            curr = new TreeNode(nums[i]);

            while (!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }

            if (!stack.isEmpty()) { stack.peek().right = curr; }
            stack.push(curr);
        }

        return stack.isEmpty() ? null : stack.getLast();
    }


    /**
     * Each node was visited, and in each visit, will find the maximum number, the maximum number divide the array into
     * two parts, so the average time complexity is O(nlogn)(if the sizes of the two parts are similar), worst case:
     * O(n2).
     *
     * Each node went into stack once, and went out stack once. Worst case time complexity O(N).
     *
     * Time Complexity: O(nlogn) worst: O(n2)
     * Space complexity: O(1)
     *
     * @param nums input array
     * @return the root of constructed tree
     */
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }

    private TreeNode construct(int[] arr, int start, int end) {
        if (start > end) { return null; }
        int maxIndex = getMaximum(arr, start, end);
        TreeNode root = new TreeNode(arr[maxIndex]);
        root.left = construct(arr, start, maxIndex-1);
        root.right = construct(arr, maxIndex+1, end);

        return root;
    }

    private int getMaximum(int[] arr, int start, int end) {
        int index = start;
        for (int i = start+1; i <= end; i++) {
            if (arr[i] > arr[index]) { index = i; }
        }

        return index;
    }


}
