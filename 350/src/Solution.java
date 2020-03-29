import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1, 3, 4, 4, 5, 5, 6};
        int[] b = {2, 2, 3, 3, 4, 4, 5};
        Solution solution = new Solution();
        int[] result = solution.intersect(a, b);
        System.out.println(Arrays.toString(result));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int temp : nums1) {
            if (map.get(temp) == null) { // 不包含这个元素，创建
                map.put(temp, 1);
            } else {
                map.put(temp, map.get(temp) + 1);
            }
        }
        Map<Integer, Integer> resultMap = new HashMap<>();
        // 求交集
        for (int temp : nums2) {
            if (map.get(temp) != null && map.get(temp) > 0) { // 包含这个元素
                if (resultMap.get(temp) == null) {
                    resultMap.put(temp, 1);
                } else {
                    resultMap.put(temp, resultMap.get(temp) + 1);
                }
                map.put(temp, map.get(temp) - 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> it = resultMap.keySet().iterator();
        while (it.hasNext()) {
            int temp = it.next();
            for (int i = 0; i < resultMap.get(temp); i++) {
                result.add(temp);
            }
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

}
