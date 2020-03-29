import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        res.clear();
        if (n <= 0 || k <= 0 || k > n)
            return res;
        List<Integer> list = new ArrayList<>();
        combine(n, k, 1, list);
        return res;
    }

    private void combine(int n, int k, int start, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            // 剪枝
            if (n - i < k - (list.size() + 1)) return;
            list.add(i);
            combine(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
