import javafx.util.Pair;

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Two {
    TreeNode tNode;
    int layer;

    public Two(TreeNode tNode, int layer) {
        this.tNode = tNode;
        this.layer = layer;
    }

    public TreeNode getKey() {
        return tNode;
    }

    public int getValue() {
        return layer;
    }
}

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<Two> queue = new ArrayDeque<>();
        List<List<Integer>> results = new ArrayList<>();
        if (root == null)
            return results;
        queue.add(new Two(root, 0));
        while (!queue.isEmpty()) {
            Two pair = queue.remove();
            TreeNode tn = pair.getKey();
            int value = pair.getValue();
            if (value < results.size()) {
                results.get(value).add(tn.val);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(tn.val);
                results.add(temp);
            }
            if (tn.left != null)
                queue.add(new Two(tn.left, value + 1));
            if (tn.right != null)
                queue.add(new Two(tn.right, value + 1));
        }
        Collections.reverse(results);
        return results;
    }
}
