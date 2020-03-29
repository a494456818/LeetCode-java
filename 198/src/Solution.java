/**
 * 记忆化搜索
 */
public class Solution {

    // memoi[i] 表示考虑抢劫 nums[i,...,n) 所能获得的最大收益
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        return tryRob(nums, 0);
    }

    // 考虑抢劫 nums[index,...,nums.size())这个范围的所有房子
    private int tryRob(int[] nums, int index) {
        if (index >= nums.length)
            return 0;

        if (memo[index] != 0)
            return memo[index];

        int res = 0;
        for (int i = index; i < nums.length; i++)
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        memo[index] = res;
        return res;
    }
}
