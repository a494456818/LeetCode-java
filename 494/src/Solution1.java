import java.util.HashMap;
import java.util.Map;

/**
 * 递归,记忆化搜索
 */
public class Solution1 {

    Map<Integer, Integer>[] memo;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0)
            return 0;
        memo = new HashMap[nums.length];
        return getAns(nums, 0, S);
    }

    public int getAns(int[] nums, int index, int obj) {
        if (index == nums.length) {
            if (obj == 0)
                return 1;
            return 0;
        }
        if (memo[index] == null)
            memo[index] = new HashMap<>();
        if (memo[index].containsKey(obj))
            return memo[index].get(obj);
        memo[index].put(obj, getAns(nums, index + 1, obj - nums[index]) + getAns(nums, index + 1, obj + nums[index]));
        return memo[index].get(obj);
    }
}
