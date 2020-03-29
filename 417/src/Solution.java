import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解题思路：
 * 1. 遍历matrix二维数组；
 * 2. 对于二维数组中的每一个数，判断是否能够同时流向大西洋和太平洋（递归）
 */
public class Solution {

    private int m, n;
    private boolean[][] visited;
    private List<int[]> res = new ArrayList<>();
    private boolean inAtlantic = false; //能流向大西洋
    private boolean inPacific = false; //能流向太平洋
    private int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private boolean[][] canBoth; // 能够同时流向大西洋和太平洋


    public List<int[]> pacificAtlantic(int[][] matrix) {
        m = matrix.length;
        if (m == 0)
            return res;
        n = matrix[0].length;
        visited = new boolean[m][n];
        canBoth = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                inAtlantic = false;
                inPacific = false;
                pacificAtlantic(matrix, i, j);
                if (inAtlantic && inPacific) {
                    this.canBoth[i][j] = true;
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    // 判断startx,starty开始的水流是否能够同时流向太平洋和大西洋
    private void pacificAtlantic(int[][] matrix, int startx, int starty) {
        if (this.canBoth[startx][starty]) {
            inPacific = true;
            inAtlantic = true;
            return;
        }
        if (startx == 0 || starty == 0)
            inPacific = true;
        if (startx == m - 1 || starty == n - 1)
            inAtlantic = true;
        if (inAtlantic && inPacific)
            return;
        visited[startx][starty] = true;
        // 朝4个方向走
        for (int i = 0; i < 4; i++) {
            int newx = startx + this.d[i][0];
            int newy = starty + this.d[i][1];
            if (inArea(newx, newy) && matrix[newx][newy] <= matrix[startx][starty] && !visited[newx][newy]) {
                pacificAtlantic(matrix, newx, newy);
            }
        }
        visited[startx][starty] = false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        Solution solution = new Solution();
        List<int[]> res = solution.pacificAtlantic(matrix);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i)));
        }
    }
}
