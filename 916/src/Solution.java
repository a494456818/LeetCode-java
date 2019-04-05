import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {

        List<String> res = new ArrayList<>();

        if (A == null || B == null || A.length == 0 || B.length == 0)
            return res;

        int n = A.length;
        int m = B.length;

        // map中的key：A[i]中某个字符，value为A[i]中某个字符出现的次数
        Map<Character, Integer>[] AMap = new Map[n];
        Map<Character, Integer> BMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            AMap[i] = new HashMap<>();
            for (int j = 0; j < A[i].length(); j++) {
                char key = A[i].charAt(j);
                AMap[i].put(key, AMap[i].getOrDefault(key, 0) + 1);
            }
        }

        for (int i = 0; i < m; i++) {
            Map<Character, Integer> temp = new HashMap<>();
            for (int j = 0; j < B[i].length(); j++) {
                char key = B[i].charAt(j);
                temp.put(key, temp.getOrDefault(key, 0) + 1);
            }
            for (Character key : temp.keySet()) {
                // BMap中存储对应某个字符出现次数的最大值即可，因为只要有一个不符合条件，那么A[i]将不是它的父集
                if (BMap.containsKey(key))
                    BMap.put(key, Math.max(BMap.get(key), temp.get(key)));
                else
                    BMap.put(key, temp.get(key));
            }
        }

        // 判断A[i]是否是B的父集
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (Character key : BMap.keySet())
                if (!AMap[i].containsKey(key) || BMap.get(key) > AMap[i].get(key))
                    flag = false;
            if (flag)
                res.add(A[i]);
        }
        return res;
    }
}