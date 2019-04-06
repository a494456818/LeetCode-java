/**
 * 动态规划
 */
public class Solution3 {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target+1]; // 有memo[i]种组合可以得到i
        memo[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i + nums[j] <= target)
                    memo[i+nums[j]] += memo[i];
            }
        }
        return memo[target];
    }
}
