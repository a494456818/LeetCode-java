import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        List<Integer> ans = new Solution().preorderTraversal(root);
        System.out.println(ans.toString());
    }

    // 非递归算法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode tNode = stack.pop();
            ans.add(tNode.val);
            if (tNode.right != null)
                stack.push(tNode.right);
            if (tNode.left != null)
                stack.push(tNode.left);
        }
        return ans;
    }
}