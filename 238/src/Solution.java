/**
 * 使用了除法
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int sum = 1;
        int zeroNum = 0; // 数组中为0的数量

        // 计算不为0的数乘积
        for (int i = 0; i < n; i++)
            if (nums[i] == 0)
                zeroNum++;
            else
                sum *= nums[i];

        for (int i = 0; i < n; i++)
            if (nums[i] == 0 && zeroNum == 1) // 只有一个数为0，那么除了这个0以外的乘积就是sum了
                nums[i] = sum;
            else if (zeroNum == 0) // 没有0
                nums[i] = sum / nums[i];
            else
                nums[i] = 0;

        return nums;
    }

}
