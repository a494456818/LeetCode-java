import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态规划
 * 定义状态：dp[i],从s[1,i)能否用字典来组成,i属于[1,s.length]
 * 状态转移矩阵：dp[i] = dp[i-wordDict[j].length] && eq(s.substring(i-wordDict[j].length,i),wordDict[j])
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
            return false;
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) { // s[1,i)是否有字典组成(这里s字符串向后平移一位，从1开始)
            for (int j = 0; j < wordDict.size(); j++) {
                int l = i-wordDict.get(j).length();
                dp[i] = l < 0 ? false : dp[l] && s.substring(l,i).equals(wordDict.get(j));
                if (dp[i])
                    break;
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        Solution solution = new Solution();
        boolean ans = solution.wordBreak(s,wordDict);
        System.out.println(ans);
    }
}
