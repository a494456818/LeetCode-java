/**
 * 动态规划
 * 状态定义：考虑偷取[0,...,x]范围里的房子
 * 状态转移方程：f(n-1) = max{v(n-1)+f(n-3),v(n-2)+f(n-4),...,v(2)+f(0),v(1),v(0)}
 */
public class Solution2 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;

        int[] memo = new int[n];

        for (int i = 0; i < n; i++)
            for (int j = i; j >= 0; j--) {
                memo[i] = Math.max(memo[i], nums[j] + (j - 2 >= 0 ? memo[j - 2] : 0));
            }
        return memo[n - 1];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int res = solution.rob(new int[]{2, 7, 9, 3, 1});
        System.out.println(res);
    }
}
