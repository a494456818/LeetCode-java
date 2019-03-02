import java.util.ArrayList;
import java.util.List;

public class Solution {

    private boolean[] col, dia1, dia2;
    private int res = 0;

    public int totalNQueens(int n) {
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1]; // n*n的矩阵有2*n-1条对角线，这是从右下到左上的对角线
        dia2 = new boolean[2 * n - 1]; // 从左上到右下的对角线
        List<Integer> row = new ArrayList<>();
        putQueen(n, 0, row);
        return res;
    }

    // 尝试在一个n皇后问题中，拜访第index行的皇后位置
    private void putQueen(int n, int index, List<Integer> row) {
        if (index == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            // 尝试将index行的皇后摆放在第i列
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1, row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.remove(row.size() - 1);
            }
        }
    }

    private List<String> generateBoard(int n, List<Integer> row) {
        assert row.size() == n;
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int c = row.get(i);
            for (int j = 0; j < n; j++)
                if (j != c) sb.append('.');
                else sb.append('Q');
            board.add(sb.toString());
        }
        return board;
    }

    public static void main(String[] args) {
        int n = 4;
        Solution solution = new Solution();
        int res = solution.totalNQueens(n);
        System.out.println(res);
    }
}
