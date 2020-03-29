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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null)
            return null;
        int low = 0, high = nums.length - 1;
        TreeNode tree = createBST(nums, low, high);
        return tree;
    }

    private TreeNode createBST(int[] nums, int low, int high) {
        if (high < low)
            return null;
        int mid = (low+high)/2;
        TreeNode tNode = new TreeNode(nums[mid]);
        tNode.left = createBST(nums,low,mid-1);
        tNode.right = createBST(nums,mid+1,high);
        return tNode;
    }
}
