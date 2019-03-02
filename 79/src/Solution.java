public class Solution {

    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length; // 行数
        assert m > 0;
        n = board[0].length; // 列数
        visited = new boolean[m][n];

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (searchWord(board, word, 0, i, j))
                    return true;
        return false;
    }

    // 从board[startx][starty]开始，寻找word[index...word.length()]
    private boolean searchWord(char[][] board, String word, int index, int startx, int starty) {
        if (index == word.length() - 1)
            return board[startx][starty] == word.charAt(index);
        if (board[startx][starty] == word.charAt(index)) {
            visited[startx][starty] = true;
            // 从startx，starty出发，向四个方向寻找
            for (int i = 0; i < 4; i++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                if (inArea(newx, newy) && !visited[newx][newy] && searchWord(board, word, index + 1, newx, newy))
                    return true;
            }
            visited[startx][starty] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        Solution solution = new Solution();
        boolean res = solution.exist(board,word);
        System.out.println(res);
    }
}
