import java.util.Arrays;

/**
 * LIS（Longest Increasing Subsequence）问题：
 * 状态：LIS(i)表示以第i个数字为结尾的最长上升子序列
 * LIS(i)表示[0...i]的范围内，选择数字nums[i]结尾可以获得的最长上升子序列的长度
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        // memo[i] 表示以nums[i]为结尾的最长上升子序列的长度
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i])
                    memo[i] = Math.max(memo[i], 1 + memo[j]);

        int res = 1;
        for (int i = 0; i < nums.length; i++)
            res = Math.max(res, memo[i]);

        return res;
    }
}
