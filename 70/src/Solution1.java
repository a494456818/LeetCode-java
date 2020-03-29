/**
 * 动态规划
 */
public class Solution1 {

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1; // 0个台阶
        memo[1] = 1; // 1个台阶
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
