import java.util.Arrays;

/**
 * 二维背包问题（动态规划）
 * 解题思路：
 *  m:0的个数，n:1的个数，可以看做背包的容量和体积
 *  strs:可以看做为物品的数量，每个物品会消耗x个0和y个1
 */
public class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0 || m < 0 || n < 0)
            return 0;

        int num = strs.length; // 物品的个数
        int[] w = new int[num];
        int[] volumn = new int[num];
        int[] v = new int[num];
        Arrays.fill(v,1); // 每个物品的价值为1
        // 统计strs中每个物品0和1的个数
        for (int i = 0; i < strs.length; i++) {
            int zero = 0, one = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0')
                    zero ++;
                else
                    one ++;
            }
            w[i] = zero;
            volumn[i] = one;
        }

        // 动态规划求解
        int[][][] memo = new int[num][m+1][n+1];
        // 初始化
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (w[0] <= i && volumn[0] <= j)
                    memo[0][i][j] = v[0];
            }
        }

        for (int i = 1; i < num; i++) { // 物品数
            for (int j = 0; j <= m; j++) { // 0的个数
                for (int k = 0; k <= n; k++) { // 1的个数
                    memo[i][j][k] = Math.max(memo[i-1][j][k] , (j-w[i]<0 || k-volumn[i] < 0) ? 0 : memo[i-1][j-w[i]][k-volumn[i]]+v[i]);
                }
            }
        }
        return memo[num-1][m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[]{"10","0001","111001","1","0"};
        int m = 5,n = 3;
        int ans = solution.findMaxForm(strs,m,n);
        System.out.println(ans);
    }
}