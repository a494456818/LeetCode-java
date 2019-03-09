import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态规划
 * 状态定义：f(x)表示从[0,...,x]中进行偷取能够偷取到的最大价值
 * 状态转移：f(x) = max(v(x)+f(x-2),v(x-1)+f(x-3),...,v(2)+f(0),v(1),v(0))
 * <p>
 * 由于头和尾不能同时取，所以分成[0,n-1)和[1,n)两部分打家劫舍，求出最大值
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int n = nums.length;
        // 第一次在[0,n-1)上偷取
        int[] memo = new int[n];
        int max = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j >= 0; j--) {
                int temp = nums[j] + (j - 2 >= 0 ? memo[j - 2] : 0);
                memo[i] = Math.max(memo[i], temp);
            }
        }
        max = memo[n - 2];

        // 第二次偷取在[1,n)上偷取
        memo = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 1; j--) {
                int temp = nums[j] + (j - 2 >= 0 ? memo[j - 2] : 0);
                memo[i] = Math.max(memo[i], temp);
            }
        }
        max = Math.max(max, memo[n - 1]);
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.rob(new int[]{2, 1, 1, 2});
        System.out.println(res);
    }
}
