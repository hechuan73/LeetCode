package Items;

public class SameTree_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (q != null && p == null) return false;
        if (q == null && p != null) return false;
        if (p.val != q.val) return false;

        boolean leftFlag = false, rightFlag = false;
        if (p.left == null && q.left == null) leftFlag = true;
        if (p.left != null && q.left != null) leftFlag = isSameTree(p.left, q.left);

        if (p.right == null && q.right == null) rightFlag = true;
        if (p.right != null && q.right != null) rightFlag = isSameTree(p.right, q.right);

        return leftFlag && rightFlag;
    }
}
