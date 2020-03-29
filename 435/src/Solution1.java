import java.util.Arrays;
import java.util.Comparator;

// 排序
class IntervalsComparator2 implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        if (o1.end != o2.end)
            return o1.end < o2.end ? -1 : 1;// -1：不交换位置，1：交换位置，从小到大排序
        return o1.start < o2.start ? -1 : 1;
    }
}

/**
 * 解法二：贪心算法
 *  按照区间的结尾排序
 *  每次选择结尾最早的，并且和前一个区间不重叠的区间
 */
public class Solution1 {

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new IntervalsComparator2());
        int res = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= intervals[pre].end) {
                res++;
                pre = i;
            }
        }
        return intervals.length - res;
    }

}
