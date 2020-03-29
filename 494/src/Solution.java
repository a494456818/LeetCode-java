/**
 * 递归
 */
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0)
            return 0;
        return getAns(nums, 0, S);
    }

    public int getAns(int[] nums, int index, int obj) {
        if (index == nums.length) {
            if (obj == 0)
                return 1;
            return 0;
        }
        return getAns(nums, index + 1, obj - nums[index]) + getAns(nums, index + 1, obj + nums[index]);
    }
}