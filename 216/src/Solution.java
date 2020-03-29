import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0)
            return res;
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = new ArrayList<>();
        combinationSum3(nums, k, n, 0, list);
        return res;
    }

    public void combinationSum3(int[] nums, int k, int n, int start, List<Integer> list) {
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (list.size() == k || n < 0)
            return;

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            combinationSum3(nums, k, n - nums[i], i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
