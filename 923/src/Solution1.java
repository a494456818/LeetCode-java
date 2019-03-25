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