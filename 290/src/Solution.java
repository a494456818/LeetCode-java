import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        Solution solution = new Solution();
        boolean flag = solution.wordPattern(pattern, str);
        System.out.println(flag);
    }

    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length)
            return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.get(ch) == null)
                map.put(ch, strs[i]);
            else if (!map.get(ch).equals(strs[i])) {
                return false;
            }
        }
        Set set = new HashSet(map.values());
        if (map.values().size() != set.size())
            return false;
        return true;
    }
}
