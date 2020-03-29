import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.res.clear();
        if (nums == null || nums.length == 0)
            return res;

        boolean[] index = new boolean[nums.length];
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        permuteUnique(nums, list, index);

        return res;
    }

    private void permuteUnique(int[] nums, List<Integer> list, boolean[] index) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (index[i]) continue;
            if (i != 0 && nums[i] == nums[i-1] && !index[i-1])continue;

            list.add(nums[i]);
            index[i] = true;

            permuteUnique(nums,list,index);

            index[i] = false;
            list.remove(list.size()-1);

        }

    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 2, 1};
        Solution1 solution = new Solution1();
        solution.permuteUnique(nums);
    }
}
