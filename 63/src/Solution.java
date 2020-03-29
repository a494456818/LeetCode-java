/**
 * 动态规划
 * 和62题（https://leetcode-cn.com/problems/unique-paths/）类似
 */
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0)
            return 0;
        int n = obstacleGrid[0].length;
        if (n == 0)
            return 0;

        int[][] grid = new int[m][n];

        boolean meetObstacle = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1 || meetObstacle) {
                grid[i][0] = 0;
                meetObstacle = true;
            }
            else
                grid[i][0] = 1;
        }
        meetObstacle = false;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1 || meetObstacle) {
                grid[0][i] = 0;
                meetObstacle = true;
            }
            else
                grid[0][i] = 1;
        }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (obstacleGrid[i][j] == 1)
                    grid[i][j] = 0;
                else
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];

        return grid[m - 1][n - 1];
    }
}
