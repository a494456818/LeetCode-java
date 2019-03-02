import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        int[] a = {1,2,2,1};
        int[] b = {2,2};
        Solution s = new Solution();
        int[] result = s.intersection(a,b);
        System.out.println(Arrays.toString(result));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int e : nums1)
            set.add(e);
        for (int e : nums2) {
            if (set.contains(e))
                resultSet.add(e);
        }
        int[] result = new int[resultSet.size()];
        Iterator<Integer> it = resultSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            result[i++] = it.next();
        }
        return result;
    }

}
