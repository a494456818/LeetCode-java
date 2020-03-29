import java.util.ArrayList;
import java.util.List;

/**
 * 解法二（反向思维）：
 * 依题意，最左边和最上面可以流向太平洋，最右边和最下面可以流向大西洋
 * 那么，可以从最左边和最上面开始dfs所有可以到达的山脉，即为可以流向太平洋的山脉
 * 从最右边和最下面开始dfs所有可以到达的山脉，即为可以流向大西洋的山脉
 * 注意：此时dfs的方向为从高度低的山脉向高度高的山脉走
 */
public class Solution1 {

    private boolean[][] pacific; // 可以流向太平洋的位置
    private boolean[][] atlantic; // 可以流向大西洋的位置
    private int row, col;

    public List<int[]> pacificAtlantic(int[][] matrix) {

        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return res;
        row = matrix.length;
        col = matrix[0].length;

        pacific = new boolean[row][col];
        atlantic = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            dfs(matrix, pacific, i, 0);
            dfs(matrix, atlantic, i, col - 1);
        }

        for (int i = 0; i < col; i++) {
            dfs(matrix, pacific, 0, i);
            dfs(matrix, atlantic, row - 1, i);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i, j});
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] map, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || map[i][j])
            return;
        map[i][j] = true;
        if (i - 1 >= 0 && matrix[i][j] <= matrix[i - 1][j])
            dfs(matrix, map, i - 1, j);
        if (j - 1 >= 0 && matrix[i][j] <= matrix[i][j - 1])
            dfs(matrix, map, i, j - 1);
        if (i + 1 < row && matrix[i][j] <= matrix[i + 1][j])
            dfs(matrix, map, i + 1, j);
        if (j + 1 < col && matrix[i][j] <= matrix[i][j + 1])
            dfs(matrix, map, i, j + 1);
    }
}
