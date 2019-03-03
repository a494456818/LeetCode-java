/**
 * 递归（记忆化搜索）
 *
 */
public class Solution1 {

    private int[] memo;

    public int integerBreak(int n) {
        assert n >= 2;
        memo = new int[n + 1];
        return integerBreak(n);
    }

    // 将n进行分割（至少分割两部分），可以获得的最大乘积
    private int breakInteger(int n) {
        if (n == 1)
            return 1;
        if (memo[n] != 0)
            return memo[n];
        int res = -1;
        for (int i = 1; i < n; i++)
            // i + (n-i)
            res = Math.max(Math.max(res, i * (n - i)), i * breakInteger(n - 1));
        memo[n] = res;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.integerBreak(10);
        System.out.println(res);
    }
}
