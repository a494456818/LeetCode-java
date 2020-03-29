/**
 * 贪心算法
 */
public class Solution {

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length())
            return false;
        if (s.length() == 0)
            return true;
        int si = 0, ti = 0;
        while (ti < t.length() && si < s.length()) {
            if (s.length() - si > t.length() - ti)
                break;
            if (s.charAt(si) == t.charAt(ti))
                si++;
            ti++;
        }
        return si == s.length();
    }

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        Solution solution = new Solution();
        boolean ans = solution.isSubsequence(s, t);
        System.out.println(ans);
    }
}
