import java.util.List;

/**
 * 动态规划
 * 空间复杂度：O(n^2)
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int m = triangle.size();
        int n = m;
        // 公式：min[0][0] = min(triangle[0][0]+triangle[1,0],triangle[0][0]+triangle[1,1])
        int[][] min = new int[m][n];
        // 最后一行初始化
        for (int i = 0; i < n; i++)
            min[m - 1][i] = triangle.get(m - 1).get(i);
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                min[i][j] = Math.min(triangle.get(i).get(j) + min[i + 1][j], triangle.get(i).get(j) + min[i + 1][j + 1]);
            }
        }
        return min[0][0];
    }
}
