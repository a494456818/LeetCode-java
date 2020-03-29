import java.util.List;

/**
 * 动态规划
 * 空间复杂度O(1)
 */
public class Solution1 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        // 公式：triangle[i][j] = min(triangle[i][j]+triangle[i+1,j],triangle[i][j]+triangle[i+1,j+1])
        for (int i = triangle.size() - 2; i >= 0; i--)
            for (int j = 0; j < triangle.get(i).size(); j++)
                triangle.get(i).set(j, Math.min(triangle.get(i).get(j) + triangle.get(i + 1).get(j), triangle.get(i).get(j) + triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }
}
