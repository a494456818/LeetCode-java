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

class Command {
    String s; // 取值：go、print
    TreeNode node;

    Command(String s, TreeNode node) {
        this.s = s;
        this.node = node;
    }
}

class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        List<Integer> ans = new Solution().postorderTraversal(root);
        System.out.println(ans.toString());
    }

    // 非递归算法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go",root));
        while (!stack.empty()) {
            Command command = stack.pop();
            if (command.s == "print")
                ans.add(command.node.val);
            else {
                assert command.s == "go" : "Command中s字段不合法，只能为go或者print";
                stack.push(new Command("print",command.node));
                if (command.node.right != null)
                    stack.push(new Command("go",command.node.right));
                if (command.node.left != null)
                    stack.push(new Command("go",command.node.left));
            }
        }
        return ans;
    }
}