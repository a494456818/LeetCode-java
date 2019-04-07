/**
 * 提交leetcode 时间超时，通过案例81/95
 * 时间复杂度：O(n^3)
 */
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;

        int n = nums.length;

        for (int i = 0; i <= n - 3; i++)
            for (int j = i + 1; j <= n - 2; j++) {
                if (nums[i] < nums[j])
                    for (int k = j + 1; k < n; k++)
                        if (nums[i] < nums[k] && nums[k] < nums[j])
                            return true;
            }

        return false;
    }
}