package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class AllElementsInTwoBinarySearchTrees_1305 {

    /**
     * Bucket Sort and dfs inorder traversal.
     *
     * @param root1 input root tree node1
     * @param root2 input root tree node2
     * @return the list of all elements.
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        int[] data = new int[200000+1];
        dfs(root1, data);
        dfs(root2, data);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = data[i]; j > 0; j--) {
                res.add(i-100000);
            }
        }

        return res;
    }

    private void dfs(TreeNode root, int[] data) {
        if (root != null) {
            dfs(root.left, data);
            data[root.val+100000]++;
            dfs(root.right, data);
        }
    }

}
