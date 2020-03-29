import java.util.ArrayList;
import java.util.List;

/**
 * 该代码重点：
 * 1. DFS思想
 * 2. 回溯
 * 3. 遍历一个字符串的所有可能性
 */
public class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return res;
        partition(s, new ArrayList<>(), 0);
        return res;
    }

    // 重点代码，可理解记忆。
    // 时间复杂度：O(2^n)
    // 空间复杂度：O(n)
    public void partition(String s, List<String> plalindromes, int l) {
        if (l == s.length()) {
            res.add(new ArrayList<>(plalindromes));
            return;
        }
        for (int i = l; i < s.length(); i++) {
            // 判断是否为回文串
            if (isPlalindrome(s.substring(l, i + 1))) {
                plalindromes.add(s.substring(l, i + 1));
                partition(s, plalindromes, i + 1);
                // 回溯
                plalindromes.remove(plalindromes.size() - 1);
            }
        }
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public boolean isPlalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> res = solution.partition("aaba");
        System.out.println(res.toString());
    }
}
