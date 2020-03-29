// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p != null && q != null) {
            if (p.val != q.val)
                return false;
            return isSymmetric(p.left,q.right) && isSymmetric(p.right,q.left);
        } else
            return false;
    }

}
