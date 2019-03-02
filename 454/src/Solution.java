import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        Solution solution = new Solution();
        int result = solution.fourSumCount(A, B, C, D);
        System.out.println(result);
    }

    // 时间复杂度：O(n^2)
    // 空间复杂度：O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // 1. 创建查找表
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++)
            for (int j = 0; j < D.length; j++)
                if (map.keySet().contains(0 - C[i] - D[j]))
                    map.put(0 - C[i] - D[j], map.get(0 - C[i] - D[j]) + 1);
                else
                    map.put(0 - C[i] - D[j], 1);
        // 2. 查找
        int result = 0;
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < B.length; j++) {
                int res = A[i] + B[j];
                if (map.containsKey(res))
                    result += map.get(res);
            }
        return result;
    }
}
