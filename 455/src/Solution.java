import java.util.Arrays;

/**
 * 贪心算法
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int max = 0;
        int si = 0;
        for (int i = 0; i < g.length && si < s.length; si++) {
            if (g[i] <= s[si]) {
                max++;
                i++;
            }
        }
        return max;
    }
}
