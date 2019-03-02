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

    // 返回值递归
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        if (root.left == null && root.right == null) { // 叶子结点
            if (sum - root.val == 0) {
                List<Integer> temp = new ArrayList<>();
                temp.add(root.val);
                ans.add(temp);
            }
            return ans;
        }

        if (root.left != null) {
            List<List<Integer>> leftS = pathSum(root.left,sum-root.val);
            for (int i = 0 ; i < leftS.size() ; i++) {
                leftS.get(i).add(0,root.val);
                ans.add(leftS.get(i));
            }
        }

        if (root.right != null) {
            List<List<Integer>> rightS = pathSum(root.right,sum-root.val);
            for (int i = 0 ; i < rightS.size() ; i++) {
                rightS.get(i).add(0,root.val);
                ans.add(rightS.get(i));
            }
        }
        return ans;
    }
}
