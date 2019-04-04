/**
 * 动态规划
 * 状态：memo[i] : 表示数组从[0,i]中能够找到的连续最大值sum(x,i)，x=[0,i]
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[] memo = new int[n];

        int max = nums[0];
        memo[0] = nums[0];

        for (int i = 1; i < n; i++) {
            memo[i] = Math.max(memo[i - 1] + nums[i], nums[i]);
            max = Math.max(max, memo[i]);
        }

        return max;
    }
}
