/**
 * 动态规划
 */
public class Solution1 {

    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Integer.MAX_VALUE;
        }
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                memo[i] = 1;
                continue;
            }
            for (int j = 1; j < i; j++) {
                // j + (i-j)
                memo[i] = Math.min(memo[i], memo[j] + memo[i - j]);
            }
        }
        return memo[n];
    }
}
