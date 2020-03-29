/**
 * 动态规划
 * 原问题等同于：找到nums一个正子集和一个负子集，使得总和等于target。
 * 我们假设P是正子集，N是负子集 例如： 假设nums = [1, 2, 3, 4, 5]，target = 3，
 * 一个可能的解决方案是+1-2+3-4+5 = 3 这里正子集P = [1, 3, 5]和负子集N = [2, 4]
 *  如何将其转换为子集求和问题?
 *      sum(P) - sum(N) = target
 *   => sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
 *   => 2 * sum(P) = target + sum(nums)
 *
 */
public class Solution2 {
    public int findTargetSumWays(int[] nums, int S) {
        //找到nums的一个子集P，使得sum(P) = (target + sum(nums))/2
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum < S || (S + sum) % 2 != 0)
            return 0;
        return subsetSum(nums, (S + sum) / 2);
    }

    public int subsetSum(int[] nums, int s) {  //以s这个数为和的子集有多少个
        int[] dp = new int[s + 1];
        dp[0] = 1;  //以0为和的子集有一个，是空集
        for (int num : nums)
            for (int i = s; i >= num; i--)
                dp[i] += dp[i - num];
        return dp[s];
    }
}
