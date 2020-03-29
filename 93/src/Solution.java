import java.util.ArrayList;
import java.util.List;

/**
 * IP 地址应满足的条件
 * 1）每一段最大值不超过255
 * 2）每一段可以为0，但是不能为011等以0开头的字符串
 */
public class Solution {

    List<String> res = new ArrayList<>();

    /**
     * @param s：已经拼接过点的字符串
     * @param index：下一个点应该从index开始选择
     * @param point：还剩余point个点没有加入到s中
     */
    public void recoveryIp(String s, int index, int point) {
        // 找到了一个答案
        if (point == 0) {
            res.add(s);
            return;
        }

        for (int i = index; i < index + 3; i++) { // IP地址每一段最大为3位且不超过255
            if (i + 1 >= s.length())
                return;
            // 在i+1位置插入点
            String newString = s.substring(0, i + 1) + '.' + s.substring(i + 1);
            // 获得插入点后当前段是否满足IP地址的要求
            String segment1Str = s.substring(index, i + 1);
            int segment1 = Integer.valueOf(segment1Str);
            String segment2 = s.substring(i + 1);
            if (segment1Str.charAt(0) == '0' && segment1Str.length() > 1) // 每一段可以为0，但是不能以0开头后接字符
                continue;
            if (segment1 > 255)
                continue;
            if (point - 1 == 0 &&  // 验证最后一段
                    (segment2.length() > 3   // 长度不能超过3
                            || (segment2.charAt(0) == '0' && segment2.length() > 1) // 可以为0，不能以0开头
                            || Integer.valueOf(segment2) > 255)) // 值必须小于等于255
                continue;
            recoveryIp(newString, i + 2, point - 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        res.clear();
        if (s.equals("") || s.length() < 4) {
            return res;
        }
        recoveryIp(s, 0, 3);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.restoreIpAddresses("172162541");
        System.out.println(solution.res.toString());
    }
}
