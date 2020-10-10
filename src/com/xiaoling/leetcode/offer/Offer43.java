package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 43. 1～n整数中1出现的次数
 * https://leetcode-cn.com/problems/number-of-digit-one/solution/shu-zi-1-de-ge-shu-by-leetcode/
 * <p>
 * 233. 数字 1 的个数
 * https://leetcode-cn.com/problems/number-of-digit-one/solution/
 *
 * @author xiaoling
 */
public class Offer43 {
    /**
     * 找规律：
     * 1. 0 ~ 9 只有一个1，那么如果某数是10的a倍，那么个位上就有a个1;
     * 2. 10 ~ 99 十位上有10个1，即10 ~ 19，那么如果某数是 100 的a倍，是10的b倍，那么十位有a * 10个1，个位有b个1，共 (a * 10 + b * 1) 个1;
     * 3. 100 ~ 999 百位上有100个，即100 ~ 199，那么如果某数是 1000 的a倍， 100 的b倍，是10的c倍，那么百位有a * 100个1，十位有b * 10个1，个位有c个1，共 (a * 100 + b * 10 + c) 个1;
     * 以此类推
     * <p>
     * 余数规则：
     * 如果某数是100的x倍，根据余数y判断实际十位共有多少1
     * 1. y >= 20，那么十位有(x + 1) * 10个1
     * 2. 10 <= y <20，那么十位有 x * 10 + (y + 1 - 10), 即y + 1 + (x - 1) * 10
     * 3. y < 10,那么十位有x * 10个1
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        long a = 1;
        long b = 10;
        int count = 0;

        while (n >= a) {
            long x = n / b;
            long y = n % b;

            if (y >= 2 * a) {
                count += (x + 1) * a;
            } else if (y >= a) {
                count += (x - 1) * a + y + 1;
            } else {
                count += x * a;
            }
            a = b;
            b = b * 10;
        }

        return count;
    }
}
