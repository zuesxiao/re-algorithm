package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q43 {
    private final String zero = "0";
    private final char cZero = '0';

    public String multiply(String num1, String num2) {
        if (zero.equals(num1) || zero.equals(num2)) {
            return zero;
        }


        String result = zero;
        for (int i = num2.length() - 1; i >= 0; i--) {
            result = add(result, multiply(num1, num2, i));
        }
        return result;
    }

    private String multiply(String num1, String num2, int index) {
        StringBuilder sb = new StringBuilder();
        int value2 = num2.charAt(index) - cZero;

        int overBit = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int tempValue = (num1.charAt(i) - cZero) * value2 + overBit;
            sb.insert(0, tempValue % 10);
            overBit = tempValue / 10;
        }

        if (overBit > 0) {
            sb.insert(0, overBit);
        }

        for (int i = index; i < num2.length() - 1; i++) {
            sb.append(zero);
        }

        return sb.toString();
    }

    private String add(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        StringBuilder sb = new StringBuilder();
        int offset = num1.length() - num2.length();
        int index = num1.length() - 1;
        int overBit = 0;
        while (index >= 0) {
            int value;
            if (index - offset >= 0) {
                value = (num1.charAt(index) - cZero) + (num2.charAt(index - offset) - cZero) + overBit;
            } else {
                value = (num1.charAt(index) - cZero) + overBit;
            }

            overBit = value / 10;
            sb.insert(0, value % 10);
            index--;
        }

        if (overBit > 0) {
            sb.insert(0, overBit);
        }

        return sb.toString();
    }

    public String multiply1(String num1, String num2) {
        if (zero.equals(num1) || zero.equals(num2)) {
            return zero;
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - cZero;
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - cZero;
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuilder ans = new StringBuilder();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }
}
