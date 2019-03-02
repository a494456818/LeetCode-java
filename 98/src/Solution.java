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
    public boolean isValidBST(TreeNode root) {
        boolean ans = true;
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        if (root.left != null) {
            ans = ans && isBST(root.left, root.val, -1) && isValidBST(root.left);
        }
        if (root.right != null) {
            ans = ans && isBST(root.right, root.val, 1) && isValidBST(root.right);
        }
        return ans;
    }

    // 判断rootVal所在的结点的左右子树是否为有序，t=-1表示左子树，t=1表示右子树
    // 左子树上的每个结点的值要小于rootVal，右子树的每个结点的值要大于rootVal
    private boolean isBST(TreeNode node, int rootVal, int t) {
        boolean res = true;
        if (node == null)
            return true;
        if (t == -1 ? node.val >= rootVal : node.val <= rootVal)
            return false;
        return isBST(node.left, rootVal, t) && isBST(node.right, rootVal, t);
    }


}
