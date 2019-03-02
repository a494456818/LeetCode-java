import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0)
            return res;
        subsets(nums, 0, new ArrayList<>());
        return res;
    }

    public void subsets(int[] nums, int start, List<Integer> list) {
        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);

            subsets(nums, i + 1, list);

            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> list = solution.subsets(nums);
        System.out.println(list.toString());
    }
}
