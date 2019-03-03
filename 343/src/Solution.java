/**
 * 动态规划
 */
public class Solution {
    public int integerBreak(int n) {
        if (n == 0)
            return 0;

        // res[i]表示将数字i分割（至少分割成两部分）后得到的最大乘积
        int[] res = new int[n + 1];

        res[1] = 1;
        for (int i = 2; i <= n; i++)
            // 求解res[i]
            for (int j = 1; j < i; j++)
                // j + (i-j)
                res[i] = Math.max(res[i], Math.max(j * (i - j), j * res[i - j]));
        return res[n];
    }
}
