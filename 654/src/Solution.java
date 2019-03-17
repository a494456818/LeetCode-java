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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = null;
        if (nums == null || nums.length == 0)
            return root;
        root = buildMaxBinaryTree(0, nums.length - 1, nums);
        return root;
    }

    // 从nums[l,r]寻找最大值构建子树
    private TreeNode buildMaxBinaryTree(int l, int r, int[] nums) {
        if (l > r)
            return null;
        int maxIndex = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildMaxBinaryTree(l, maxIndex - 1, nums);
        root.right = buildMaxBinaryTree(maxIndex + 1, r, nums);
        return root;
    }
}