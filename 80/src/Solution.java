class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int end = 1;
        int flag = 0; // 计数，是否出现两次

        for (int i = 1; i < n; i++) {
            if (nums[end - 1] == nums[i]) {
                if (flag == 0) { // 如果只出现一次，那么让该元素继续出现
                    nums[end] = nums[i];
                    end++;
                    flag++;
                }
            }
            if (nums[end - 1] != nums[i]) {
                nums[end] = nums[i];
                end++;
                flag = 0;
            }
        }
        return end;
    }
}