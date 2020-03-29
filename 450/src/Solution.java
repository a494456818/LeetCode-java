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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) // 是个空树，直接返回空
            return root;
        if (key < root.val) { // 在左子树中
            root.left = deleteNode(root.left,key);
            return root;
        } else if (key > root.val) { // 在右子树中
            root.right = deleteNode(root.right,key);
            return root;
        } else { // 找到要删除的结点
            if (root.left == null) // 没有左子树，直接返回右子树
                return root.right;
            if (root.right == null) // 没有右子树，直接返回左子树
                return root.left;
            // 左右孩子都存在,使用右子树的最左结点作为根节点
            TreeNode node = min(root.right);
            node.right = delMin(root.right);
            node.left = root.left;
            return node;
        }
    }

    // 寻找最左结点
    private TreeNode min(TreeNode node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    // 删除最左结点后，重构右子树
    private TreeNode delMin(TreeNode node) {
        if (node.left == null)
            return node.right;
        node.left = delMin(node.left);
        return node;
    }
}
