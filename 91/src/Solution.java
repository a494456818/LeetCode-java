/**
 * 动态规划
 * 与爬楼梯类似，只是增加了限制条件
 * 可以发现规律f(n) = f(n-1)+f(n-2)
 *
 * f(n-1) = 0  if (s[n-1] == '0')
 * else   = f((n-1)-1)+f((n-1)-2)
 *
 * f(n-2) = 0 if (s[n-2] == '0' || s[n-2:n-1] > '26')
 * else   = f((n-2)-1)+f((n-2)-2)
 *
 * if s[0] != '0', initialize variable:
 *  f(0) = 1
 *  f(1) = 1
 */
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return s.charAt(0) == '0' ? 0 : 1;
        int[] memo = new int[s.length()+1];
        if (s.charAt(0) == '0')
            return 0;
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i-1) == '0')
                memo[i-1] = 0;
            if (s.charAt(i-2) == '0' || Integer.valueOf(s.substring(i-2,i)) > 26)
                memo[i-2] = 0;
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[s.length()];
    }
}
