/**
 * 暴力解法（超时）：
 * 时间复杂度：O(n^3)
 */
public class Solution {

    public int threeSumMulti(int[] A, int target) {
        if (A == null || A.length == 0)
            return 0;
        int ans = 0;
        for (int i = 0; i < A.length-2; i++) {
            for (int j = i+1; j < A.length-1; j++) {
                for (int k = j+1; k < A.length; k++) {
                    if (A[i] + A[j] + A[k] == target)
                        ans++;
                }
            }
        }
        return ans;
    }
}
