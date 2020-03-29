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

    private int time = 0;

    public int kthSmallest(TreeNode root, int k) {
        int res = 0;
        if (root == null)
            return res;
        int left = kthSmallest(root.left, k);

        if (++time == k)
            return root.val;
        if (k < time)
            return left;

        return kthSmallest(root.right, k);
    }
}
