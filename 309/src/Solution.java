import java.util.Arrays;

/**
 * 动态规划：
 * 状态定义：f(x)表示在[x,n)中交易所获得收益的最大值
 * 状态转换：f(x) = max(f(x+1),v(x+1)-v(x)+f(x+3),v(x+2)-v(x)+f(x+4),v(n-2)-v(x),v(n-1)-v(x))
 * f(n) = 0
 * f(n-1) = 0
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1)
            return 0;
        int n = prices.length;
        int[] memo = new int[n];
        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                // 购买股票i
                memo[i] = Math.max(memo[i],prices[j]-prices[i]+(j+2 < n-1 ? memo[j+2] : 0));
            }
            // 不购买股票i
            memo[i] = Math.max(memo[i],memo[i+1]);
        }
        return memo[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxProfit(new int[]{1,2});
        System.out.println(res);
    }
}
