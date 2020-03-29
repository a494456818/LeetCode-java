import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String s = "a";
        String t = "ab";
        Solution solution = new Solution();
        boolean flag = solution.isAnagram(s,t);
        System.out.println(flag);

    }

    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.get(ch) == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        // 判断是否为字母异位词
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch) == null || map.get(ch) <= 0)
                return false;
            else {
                map.put(ch, map.get(ch) - 1);
            }
        }

        // map中的value是否全为0
        Iterator<Character> it = map.keySet().iterator();
        while (it.hasNext()) {
            char ch = it.next();
            if (map.get(ch) != 0)
                return false;
        }
        return true;
    }

}
