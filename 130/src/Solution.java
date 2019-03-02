import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private boolean[][] visited;
    private int m;
    private int n;
    private boolean isInclude; // 是否包含

    public void solve(char[][] board) {
        this.m = board.length;
        if (m == 0)
            return;
        n = board[0].length;
        visited = new boolean[m][n];

        List<Integer[]> list = new ArrayList<>();
        for (int i = 1; i < m - 1; i++)
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    this.isInclude = true;
                    list.clear();
                    dfs(board, i, j, list);
                    if (this.isInclude)
                        for (int k = 0; k < list.size(); k++)
                            board[list.get(k)[0]][list.get(k)[1]] = 'X';
                }
            }
    }

    private void dfs(char[][] board, int startx, int starty, List<Integer[]> list) {
        if (startx == 0 || startx == this.m - 1 || starty == 0 || starty == this.n - 1) {
            list.clear();
            isInclude = false;
        }

        visited[startx][starty] = true;
        if (isInclude)
            list.add(new Integer[]{startx, starty});
        // 判断上下左右是否被堵住,没有堵住继续访问
        for (int i = 0; i < 4; i++) {
            int newx = startx + this.d[i][0];
            int newy = starty + this.d[i][1];
            if (inArea(newx, newy) && board[newx][newy] == 'O' && !visited[newx][newy])
                dfs(board, newx, newy, list);
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solution.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
