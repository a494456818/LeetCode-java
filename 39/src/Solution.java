import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0 || target <= 0)
            return res;
        Arrays.sort(candidates);
        if (target < candidates[0])
            return res;

        List<Integer> list = new ArrayList<>();

        combinationSum(candidates, 0, 0, list, target);

        return res;
    }

    private void combinationSum(int[] candidates, int curSum, int start, List<Integer> list, int target) {
        if (curSum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (curSum > target)
            return;
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            list.add(candidates[i]);
            combinationSum(candidates, curSum + candidates[i], i, list, target);
            list.remove(list.size() - 1);
        }
    }
}
