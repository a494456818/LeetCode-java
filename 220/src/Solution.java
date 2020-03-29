import sun.reflect.generics.tree.Tree;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3, t = 0;
        Solution solution = new Solution();
        boolean flag = solution.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(flag);
    }

    // 时间复杂度：O(nlogn)
    // 空间复杂度：O(k)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.ceiling((long) nums[i] - (long) t) != null && set.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t)
                return true;
            set.add((long) nums[i]);
            if (set.size() == k + 1) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
