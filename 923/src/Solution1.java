/**
 * 解题思路：
 *  由于需要找到x,y,z使得x+y+z=target，只要找到x,y,z即可，顺序并不重要。
 *  对于x+y+z==target，主要存在三种情况：
 *      1. a==b==c ： a,b,c相等，所有的组合数量为：C_n^3（n为等于a的数量）
 *      2. a==b!=c ： 有两个数相等，所有的组合数量为：C_n^2 * m (n为等于a的数量，m为c的数量)
 *      3. a<b && b<c ：值为a的数量*b的数量*c的数量
 */
class Solution1 {
    public static int threeSumMulti(int[] A, int target) {
        long res = 0;
        int mod = 1000000007;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] count = new int[101];
        for (int i = 0; i < A.length; i++) {
            count[A[i]]++;
            max = A[i] > max ? A[i] : max;
            min = A[i] < min ? A[i] : min;
        }
        for (int i = min; i <= max; i++) {
            if (count[i] == 0)
                continue;
            for (int j = i; j <= max; j++) {
                if (count[j] == 0)
                    continue;
                int temp = target - i - j;
                if (temp >= j && temp <= max && count[temp] > 0) {
                    res += getCount(i, j, temp, count[i], count[j], count[temp]);
                }
            }
        }
        return (int) (res % mod);
    }

    private static long getCount(int a, int b, int c, long i, long j, long k) {
        if (a == b) {
            if (b == c) {
                if (i < 3) {
                    return 0;
                } else {
                    return i * (i - 1) * (i - 2) / 6;
                }
            } else {
                if (i < 2) {
                    return 0;
                } else {
                    return i * (i - 1) / 2 * k;
                }
            }
        } else if (b == c) {
            if (j < 2) {
                return 0;
            } else {
                return j * (j - 1) / 2 * i;
            }

        } else {
            return i * j * k;
        }
    }
}