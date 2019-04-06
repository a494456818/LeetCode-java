/**
 * 方法一：
 * 普通递归的方法
 * 提交到LeetCode，时间超时
 */
public class Solution1 {

    public int combinationSum4(int[] nums, int target) {
        if (target == 0)
            return 1;
        int res = 0;
        for (int i = 0; i < nums.length; i++)
            if (target >= nums[i])
                res += combinationSum4(nums, target - nums[i]);
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int ans = solution.combinationSum4(new int[]{2, 1, 3}, 35);
        System.out.println("answer is : " + ans);
    }
}
