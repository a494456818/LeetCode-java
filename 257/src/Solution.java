import java.util.ArrayList;
import java.util.List;

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
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder path = new StringBuilder();
        List<String> results = new ArrayList<>();
        if (root == null)
            return results;
        getAllPath(root, path, results);
        return results;
    }

    public void getAllPath(TreeNode root, StringBuilder path, List<String> results) {
        if (root.left == null && root.right == null) { // 到了叶子结点
            path.append(root.val);
            results.add(path.toString());
            return;
        }
        path.append(root.val + "->");
        if (root.left != null)
            getAllPath(root.left, new StringBuilder(path.toString()), results);
        if (root.right != null)
            getAllPath(root.right, new StringBuilder(path.toString()), results);
    }

}
