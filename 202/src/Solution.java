import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean flag = solution.isHappy(19);
        System.out.println(flag);
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            int sum = 0;
            while(n != 0) {
                int res = n%10;
                sum += res*res;
                n = n/10;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }

}
