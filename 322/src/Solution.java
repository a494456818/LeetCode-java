import java.util.Arrays;

/**
 * 动态规划
 * 时间复杂度：O(n*amount)  n为硬币个数
 * 空间复杂度：O(n*amount)
 * 可优化，可以查看0-1背包的优化，可以将空间复杂度优化至O(amount)
 */
public class Solution {

    private int[][] memo;
    private int[][] num;
    private int min = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (coins == null || amount < 0)
            return -1;
        if ((coins.length == 0 && amount == 0) || amount == 0)
            return 0;
        else if (coins.length == 0 && amount > 0)
            return -1;

        int n = coins.length;
        memo = new int[n][amount + 1];
        num = new int[n][amount + 1];
        int j = 1;
        for (int i = 0; i <= amount; i++) {
            if (j * coins[0] > i) {
                memo[0][i] = (j - 1) * coins[0];
                num[0][i] = j - 1;
            } else {
                if (j * coins[0] == amount)
                    min = Math.min(min, j);
                memo[0][i] = j * coins[0];
                num[0][i] = j;
                j++;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int k = 0; k <= amount; k++) {
                memo[i][k] = memo[i - 1][k];
                num[i][k] = num[i - 1][k];
                if (coins[i] <= k) {
                    int temp1 = coins[i] + memo[i - 1][k - coins[i]];
                    int temp2 = coins[i] + memo[i][k - coins[i]];
                    int max = -1;
                    int t = -1;
                    if (temp1 > temp2) {
                        max = temp1;
                        t = num[i - 1][k - coins[i]] + 1;
                    } else if (temp1 == temp2) {
                        max = temp1;
                        t = num[i - 1][k - coins[i]] > num[i][k - coins[i]] ? num[i][k - coins[i]] + 1 : num[i - 1][k - coins[i]] + 1;
                    } else {
                        max = temp2;
                        t = num[i][k - coins[i]] + 1;
                    }
                    if (memo[i][k] < max) {
                        memo[i][k] = max;
                        num[i][k] = t;
                    } else if (memo[i][k] == max) {
                        num[i][k] = num[i][k] > t ? t : num[i][k];
                    }
                    if (memo[i][k] == amount) {
                        min = Math.min(num[i][k], min);
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.coinChange(new int[]{1,1,1,2,3}, 3);
        System.out.println("answer is : " + ans);
    }
}
