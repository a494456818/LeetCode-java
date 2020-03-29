import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution solution = new Solution();
        List<List<String>> result = solution.groupAnagrams(strs);
        for (List<String> list : result) {
            System.out.println(list);
        }

    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String str = String.valueOf(chs);
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<String>());
            }
            map.get(str).add(strs[i]);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
