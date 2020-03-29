import java.util.Arrays;

/**
 * 定义状态：memo[i]表示以nums[i]结尾的最长摆动子序列
 * 状态转移：memo[i] = if( nums[i]接在nums[j]后面能组成摆动序列 ) memo[i] = max(memo[i],memo[j]+1)
 * 时间复杂度：O(n^2)
 */
public class Solution {

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] memo = new int[nums.length];
        int[] updown = new int[nums.length];// 0:后接的数可升可降 1：后接的数必须升 2：后接的数必须降
        Arrays.fill(memo, 1);
        memo[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (updown[j] == 0) {
                    if (nums[i] > nums[j]) {
                        memo[i] = memo[j] + 1;
                        updown[i] = 2;
                    } else if (nums[i] < nums[j]) {
                        memo[i] = memo[j] + 1;
                        updown[i] = 1;
                    }
                } else if (updown[j] == 1 && nums[i] > nums[j]) {
                    if (memo[i] < memo[j] + 1) {
                        memo[i] = memo[j] + 1;
                        updown[i] = 2;
                    }
                } else if (updown[j] == 2 && nums[i] < nums[j]) {
                    if (memo[i] < memo[j] + 1) {
                        memo[i] = memo[j] + 1;
                        updown[i] = 1;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++)
            max = Math.max(max, memo[i]);
        return max;
    }
}
