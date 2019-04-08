import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 解题思路：
 * 正方形具有的性质：四条边x相等，对角线y相等
 * 所以利用该性质，直接求四条边相互之间的距离
 * 如果是正方形：只有可能得出x,y两种值，并且x!=0,y!=0
 * 否则：不止两种值
 */
public class Solution {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> res = new HashSet<>();
        res.add(getInstance(p1, p2));
        res.add(getInstance(p1, p3));
        res.add(getInstance(p1, p4));
        res.add(getInstance(p2, p3));
        res.add(getInstance(p2, p4));
        res.add(getInstance(p3, p4));
        return res.size() == 2 && !res.contains(0);
    }

    private int getInstance(int[] x1, int[] x2) {
        return (int) (Math.pow(x1[0] - x2[0], 2) + Math.pow(x1[1] - x2[1], 2));
    }

}
