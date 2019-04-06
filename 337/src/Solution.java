/**
 * 动态规划
 * 状态定义：f(root,0)表示root结点可以偷取，f(root,1)表示root结点不可以偷取，只能偷取下一个结点
 * 状态转移矩阵：f(root,0) = max(v(root)+f(root.left,1)+f(root.right,1) , f(root.left,0) + f(root.right,0))
 * f(root,1) = f(root.left,0)+f(root.right,0)
 */


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

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        return f(root,0);
    }

    public int f(TreeNode root,int t) {
        if (root == null)
            return 0;
        if (t == 0) {
            return Math.max(root.val+f(root.left,1)+f(root.right,1),f(root.left,0)+f(root.right,0));
        } else
            return f(root.left,0)+f(root.right,0);
    }
}
