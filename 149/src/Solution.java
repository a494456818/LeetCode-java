import java.util.*;

// Definition for a point.
class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Point[] points = new Point[6];
        int[][] p = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
//        int[][] p = {{1,1},{2,2},{3,3}};
        for (int i = 0 ; i < p.length ; i++) {
            Point point = new Point(p[i][0],p[i][1]);
            points[i] = point;
        }
        int result = solution.maxPoints(points);
        System.out.println(result);
    }


    public int maxPoints(Point[] points) {
        int n = points.length;
        if(0 == n) {
            return 0;
        }
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            int size = 1;
            int same = 0;
            HashMap<Integer[], Integer> hashMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if(i != j) {
                    if(points[i].x != points[j].x) {
                        int dy = points[i].y - points[j].y;
                        int dx = points[i].x - points[j].x;
                        int gcd = gcd(dy, dx);
                        if(0 != gcd) {
                            dy = dy /gcd;
                            dx = dx / gcd;
                        }
                        Integer[] nums = new Integer[2];
                        nums[0] = dy;
                        nums[1] = dx;
                        boolean flag = false;
                        for (Integer[] array : hashMap.keySet()) {
                            if(nums[0] == array[0] && nums[1] == array[1]) {
                                flag = true;
                                hashMap.put(array, hashMap.get(array) + 1);
                            }
                        }
                        if(!flag) {
                            hashMap.put(nums, 1);
                        }
                    }else {
                        if(points[i].y == points[j].y) {
                            same++;
                        }
                        size++;
                    }
                }
            }
            for (Integer[] array : hashMap.keySet()) {
                if(hashMap.get(array) + 1 > count[i]) {
                    count[i] = hashMap.get(array) + 1;
                }
            }
            count[i] += same;
            count[i] = Math.max(count[i], size);
        }
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if(count[i] > count[maxIndex]) {
                maxIndex = i;
            }
        }
        return count[maxIndex];
    }
    private int gcd(int x, int y) {
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }
}
