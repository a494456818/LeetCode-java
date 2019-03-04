
// Definition for a binary tree node.

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Solution {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0)
            return res;
        res = createTree(1, n);
        return res;
    }

    // 从[l,r]构造一颗子树
    private List<TreeNode> createTree(int l, int r) {
        List<TreeNode> res = new ArrayList<>();
        // 保证了左边的数是小于右边的
        if (l > r) {
            res.add(null);
            return res;
        }
        for (int i = l; i <= r; i++) {
            // 每次使用i节点作为根节点，[l,i-1]作为左子树，[i+1,r]作为右子树构建一颗树
            List<TreeNode> leftTree = createTree(l, i - 1);
            List<TreeNode> rightTree = createTree(i + 1, r);
            // 每一个左子树，都可以和不同形态的右子树组合
            for (int j = 0; j < leftTree.size(); j++)
                for (int k = 0; k < rightTree.size(); k++) {
                    TreeNode t = new TreeNode(i);
                    t.left = leftTree.get(j);
                    t.right = rightTree.get(k);
                    res.add(t);
                }
        }
        return res;
    }
}
