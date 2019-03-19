/**
 * 递归（leetcode超时）
 */
public class Solution {

    private int[][] ans;
    private int m, n;
    private int[][] direct = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean[][] visited;

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return matrix;
        m = matrix.length;
        n = matrix[0].length;
        ans = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    visited[i][j] = true;
                    ans[i][j] = findAns(matrix, i, j);
                    visited[i][j] = false;
                }
            }
        }
        return ans;
    }

    private int findAns(int[][] matrix, int r, int c) {
        int min = Integer.MAX_VALUE;
        if (matrix[r][c] == 0)
            return 0;
        if (matrix[r][c] == 1 && ans[r][c] != 0)
            return ans[r][c];
        // 从matrix[r][c]开始找最优的解
        for (int i = 0; i < 4; i++) {
            int new_r = r + direct[i][0];
            int new_c = c + direct[i][1];
            if (new_r >= 0 && new_r < m && new_c >= 0 && new_c < n && !visited[new_r][new_c]) {
                visited[new_r][new_c] = true;
                min = Math.min(min, findAns(matrix, new_r, new_c)+1);
                visited[new_r][new_c] = false;
            }
        }
        if (min == Integer.MAX_VALUE)
            return 0;
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {
                1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {
                0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {
                1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        int[][] ans = solution.updateMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
