import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void solveSudoku(char[][] board) {
        // 1. 用于计算行是否重复
        int[][] row = new int[9][10];
        // 2. 用于计算列是否重复
        int[][] col = new int[9][10];
        // 3. 用于计算3X3格子是否重复
        int[][] box = new int[9][10];

        // 4. 给1,2,3步骤赋初值
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch >= '0' && ch <= '9') {
                    int num = ch - '0';
                    row[i][num] = 1;
                    col[j][num] = 1;
                    int no = 3 * (i / 3) + j / 3;
                    box[no][num] = 1;
                }
            }
        }

        int x0 = 0, x1 = 0; // 从(0,0)位置开始递归
        List<Integer> flag = new ArrayList<>();
        flag.add(0);

        dfs(board, x0, x1, row, col, box, flag);
    }

    public void dfs(char[][] board, int x0, int x1, int[][] row, int[][] col, int[][] box, List<Integer> flag) {
        // 检查是否已经找到答案
        if (flag.get(0) == 81) {
            return;
        }

        if (x0 > 8) {
            return;
        }

        // 下一步往哪里走
        int new_x0 = x0, new_x1 = x1;
        if (x1 + 1 < 9) {
            new_x1 = x1 + 1;
        } else {
            new_x1 = 0;
            new_x0 = x0 + 1;
        }

        // 1. 获取当前字符
        char ch = board[x0][x1];

        // 2. 判断是否是是数字
        if (!(ch >= '0' && ch <= '9')) {
            // 查找该位置可以填充的数字
            for (int i = 1; i <= 9; i++) {
                if (row[x0][i] == 0 && col[x1][i] == 0 && box[3 * (x0 / 3) + x1 / 3][i] == 0) {

                    // 填充该数字
                    board[x0][x1] = (char) ('0' + i);

                    row[x0][i] = 1;
                    col[x1][i] = 1;
                    box[3 * (x0 / 3) + x1 / 3][i] = 1;

                    flag.set(0, flag.get(0) + 1);

                    dfs(board, new_x0, new_x1, row, col, box, flag);

                    // 回溯前检查是否已经找到答案
                    if (flag.get(0) == 81) {
                        return;
                    }

                    flag.set(0, flag.get(0) - 1);

                    board[x0][x1] = ch;
                    row[x0][i] = 0;
                    col[x1][i] = 0;
                    box[3 * (x0 / 3) + x1 / 3][i] = 0;
                }
            }
        } else {
            flag.set(0, flag.get(0) + 1);
            dfs(board, new_x0, new_x1, row, col, box, flag);
            // 回溯前检查是否已经找到答案
            if (flag.get(0) == 81) {
                return;
            }
            flag.set(0, flag.get(0) - 1);
        }
    }
}
