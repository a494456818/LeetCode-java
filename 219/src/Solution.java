import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        Solution solution = new Solution();
        boolean flag = solution.containsNearbyDuplicate(nums, k);
        System.out.println(flag);
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(k)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}
