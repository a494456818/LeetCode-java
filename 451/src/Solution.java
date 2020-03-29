import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String s = "tree";
        Solution solution = new Solution();
        String result = solution.frequencySort(s);
        System.out.println(result);
    }

    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if (!map.keySet().contains(ch)) {
                map.put(ch,1);
            } else {
                map.put(ch,map.get(ch)+1);
            }
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                int x = o1.getValue(), y = o2.getValue();
                return (x > y) ? -1 : ((x == y) ? 0 : 1);
            }
        });
        StringBuilder result = new StringBuilder();
        for(Map.Entry<Character,Integer> mapping:list){
            for (int i = 0 ; i < mapping.getValue() ; i++) {
                result.append(mapping.getKey());
            }
        }
        return result.toString();
    }
}
