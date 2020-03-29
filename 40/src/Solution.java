import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return res;
        boolean[] view = new boolean[candidates.length];
        Arrays.sort(candidates);
        combinationSum2(candidates, 0, 0, new ArrayList<>(), target, view);
        return res;
    }

    private void combinationSum2(int[] candidates, int start, int sum, List<Integer> list, int target, boolean[] view) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target)
            return;
        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            if (i != 0 && candidates[i] == candidates[i - 1] && !view[i - 1]) continue;

            view[i] = true;
            list.add(candidates[i]);

            combinationSum2(candidates, i + 1, sum + candidates[i], list, target, view);

            view[i] = false;
            list.remove(list.size() - 1);
        }
    }

}
