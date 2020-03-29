import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Solution solution = new Solution();
        int result = solution.numberOfBoomerangs(points);
        System.out.println(result);
    }
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(n)
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int[] center = points[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;
                // 计算points[j]到center的距离
                int distance = (center[0] - points[j][0]) * (center[0] - points[j][0]) + (center[1] - points[j][1]) * (center[1] - points[j][1]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            // 判断组合的可能性
            for (int key : map.keySet()) {
                res += map.get(key) * (map.get(key)-1);
            }
        }
        return res;
    }
}
