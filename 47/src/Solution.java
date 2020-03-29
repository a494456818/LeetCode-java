import java.util.ArrayList;
import java.util.List;

// 该解法相当于求出所有的排列，然后去除重复
// 在去重时时间复杂度为O(n^2)，效率低
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
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
        if (nums.size() == 0 && !this.res.contains(temp)) // 去重
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
