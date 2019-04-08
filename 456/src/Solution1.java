import java.util.Arrays;

/**
 * 依然超时，通过案例：94/95
 * 时间复杂度：O(n^2)
 */
public class Solution1 {

    public boolean find132pattern(int[] nums) {

        if (nums == null || nums.length < 3)
            return false;

        int n = nums.length;
        int[] memo = new int[n]; // memo[i]表示能否返回32
        Arrays.fill(memo, Integer.MIN_VALUE);

        // 寻找32
        for (int i = 0; i < n - 1; i++) { // nums[i]作为3，寻找2
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    memo[i] = Math.max(memo[i], nums[j]);
                    if (nums[i] - nums[j] == 1)
                        break;
                }
            }
        }

        // 寻找13
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i] < nums[j] && memo[j] != Integer.MIN_VALUE && nums[i] < memo[j])
                    return true;
            }
        }

        return false;
    }
}
