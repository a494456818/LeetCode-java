/**
 * 递归方法（记忆化搜索）
 */
public class Solution {

    private int[] memo;

    public int climbStairs(int n) {
        if (n == 0) // 没有台阶，只有一种爬法：就是一个台阶也不爬
            return 1;
        memo = new int[n + 1];
        return calcWays(n);
    }

    private int calcWays(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (memo[n] == 0)
            memo[n] = calcWays(n - 1) + calcWays(n - 2);
        return memo[n];
    }
}
