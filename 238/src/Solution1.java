/**
 * 不使用除法
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution1 {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int num = 1;
        int[] res = new int[n]; // res[i]存储nums[0,i-1]的乘积

        for (int i = 0; i < n; i++) {
            res[i] = num;
            num *= nums[i];
        }

        num = 1;
        for (int i = n-1; i >= 0; i--) {
            res[i] *= num;
            num *= nums[i];
        }

        return res;
    }

}
