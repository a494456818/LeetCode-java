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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1);
    }

    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

}
