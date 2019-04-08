import java.util.Stack;

/**
 * 使用栈
 */
public class Solution2 {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int last = Integer.MIN_VALUE; // 132中的2
        Stack<Integer> sta = new Stack<>();// 用来存储132中的3
        if (nums.length < 3)
            return false;
        for (int i = n - 1; i >= 0; i--) {

            if (nums[i] < last) // 若出现132中的1则返回正确值
                return true;

            // 若当前值大于或等于2则更新2（2为栈中小于当前值的最大元素）
            while (!sta.isEmpty() && sta.peek() < nums[i])
                last = sta.pop();

            // 将当前值压入栈中
            sta.push(nums[i]);
        }
        return false;
    }

}
