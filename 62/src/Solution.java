/**
 * 动态规划
 * 思路：
 * 1. 初始化：grid[0...m-1][0...n-1];
 * 2. 由于只能向右和下移动，所以第一行、第一列只有一种方法可以到达，即：
 * grid[0][*] = 1,grid[*][0] = 1;
 * 3. 除了第一行，第一列，其余根据递推式grid[m][n] = grid[m-1][n] + grid[m][n-1] 计算
 * 4. grid[m-1][m-1]即为所求
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            grid[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            grid[0][i] = 1;
        }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];

        return grid[m - 1][n - 1];
    }
}
