/**
 * 动态规划
 * 对状态的定义：考虑偷取[x,...,n-1]范围里的房子
 * 状态转移方程：f(x) = max{v(x)+f(x+2), v(x+1)+f(x+3), v(x+2)+f(x+4),..., v(n-3)+f(n-1), v(n-2),v(n-1)}
 */
public class Solution1 {
    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0)
            return 0;

        // memoi[i] 表示考虑抢劫 nums[i,...,n-1] 所能获得的最大收益
        int[] memo = new int[n];
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--)
            // memo[i]
            for (int j = i; j < n; j++)
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));

        return memo[0];
    }
}
