import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        getList(root,0);
        return list;
    }

    private void getList(TreeNode root,int deep) {
        if (root == null)
            return ;
        if (deep == list.size())
            list.add(root.val);
        getList(root.right,deep+1);
        getList(root.left,deep+1);
    }

}
