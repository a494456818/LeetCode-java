/**
 * 贪心算法
 * 时间复杂度：O(n)
 */
public class Solution1 {

    public int wiggleMaxLength(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return up > down ? up : down;
    }
}