import java.util.Arrays;

/**
 * 方法二：
 * 记忆化搜索
 */
public class Solution2 {

    private int[] memo;

    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return search(nums, target);
    }

    private int search(int[] nums, int target) {
        if (memo[target] != -1)
            return memo[target];
        int res = 0;
        for (int i = 0; i < nums.length; i++)
            if (target >= nums[i])
                res += search(nums, target - nums[i]);
        memo[target] = res;
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int ans = solution.combinationSum4(new int[]{2, 1, 3}, 35);
        System.out.println("answer is : " + ans);
    }
}
