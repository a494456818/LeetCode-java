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

    private int result = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null)
            root.left.val += root.val * 10;
        if (root.right != null)
            root.right.val += root.val * 10;
        if (root.left == null && root.right == null)
            result += root.val;
        sumNumbers(root.left);
        sumNumbers(root.right);
        return result;
    }
}
