package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class BinaryTreePaths_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) { return res; }
        buildPath(res, new StringBuilder(), root);
        return res;
    }

    private void buildPath(List<String> res, StringBuilder lastPath, TreeNode root) {
        StringBuilder sb = new StringBuilder(lastPath);
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            return;
        }
        sb.append("->");
        if (root.left != null) { buildPath(res, sb, root.left);}
        if (root.right != null) { buildPath(res, sb, root.right);}
    }
}
