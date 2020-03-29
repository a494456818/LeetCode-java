import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new ArrayList<>(),new boolean[nums.length]);
        return res;
    }

    public void subsetsWithDup(int[] nums, int start, List<Integer> list,boolean[] view) {
        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1] && !view[i-1]) continue;
            list.add(nums[i]);
            view[i] = true;

            subsetsWithDup(nums, i + 1, list,view);

            list.remove(list.size() - 1);
            view[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Solution solution = new Solution();
        List<List<Integer>> list = solution.subsetsWithDup(nums);
        System.out.println(list.toString());
    }
}
