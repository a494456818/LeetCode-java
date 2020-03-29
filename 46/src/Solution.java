import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permute(a);
        System.out.println(res.toString());
    }

    public List<List<Integer>> permute(int[] nums) {
        this.res.clear();
        if (nums == null || nums.length == 0)
            return res;
        List<Integer> temp = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        permute(numsList, temp);
        return res;
    }

    private void permute(List<Integer> nums, List<Integer> temp) {
        if (nums.size() == 0)
            this.res.add(new ArrayList<>(temp));
        for (int i = 0; i < nums.size(); i++) {
            int t = nums.get(i);
            temp.add(nums.get(i));
            nums.remove(i);

            permute(nums, temp);

            nums.add(i, t);
            temp.remove(temp.size() - 1);
        }
        return;
    }
}
