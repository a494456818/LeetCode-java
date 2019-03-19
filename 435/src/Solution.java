import java.util.Arrays;
import java.util.Comparator;

// Definition for an interval.
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

// 排序
class IntervalsComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        if (o1.start != o2.start)
            return o1.start < o2.start ? -1 : 1;// -1：不交换位置，1：交换位置，从小到大排序
        return o1.end < o2.end ? -1 : 1;
    }
}

/**
 * 解法一：动态规划
 * 该问题类似于寻找最长递增子序列
 */
public class Solution {

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new IntervalsComparator());
        // memo[i] 表示使用intervals[0...i]的区间能构成的最长不重叠区间序列
        int[] memo = new int[intervals.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < intervals.length; i++)
            // memo[i]
            for (int j = 0; j < i; j++)
                if (intervals[i].start >= intervals[j].end)
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
        int res = 0;
        for (int i = 0; i < intervals.length; i++)
            res = Math.max(res, memo[i]);
        return intervals.length - res;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[4];
        intervals[0] = new Interval(1,100);
        intervals[1] = new Interval(11,22);
        intervals[2] = new Interval(1,11);
        intervals[3] = new Interval(2,12);
        Solution solution = new Solution();
        solution.eraseOverlapIntervals(intervals);
    }

}
