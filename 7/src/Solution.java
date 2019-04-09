public class Solution {
    public int reverse(int x) {
        long sum = 0;
        while (x != 0) {
            sum = sum * 10 + x % 10;
            x /= 10;
        }
        // 在 [−2^31,  2^31 − 1] 中，直接返回，否则int类型会溢出返回0.
        if (sum <= 2147483647 && sum >= -2147483648)
            return (int) sum;
        return 0;
    }
}
