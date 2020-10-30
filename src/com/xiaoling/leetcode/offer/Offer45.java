package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 *
 * @author xiaoling
 */
public class Offer45 {
    public String minNumber(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return String.valueOf(nums[0]);
        }

        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = Integer.toString(nums[i]);
        }

        quickSort(strings, 0, nums.length - 1);

        StringBuilder sb = new StringBuilder();
        for (String num : strings) {
            sb.append(num);
        }
        return sb.toString();
    }

    private void quickSort(String[] strings, int left, int right) {
        if (left >= right) {
            return;
        }

        String base = strings[left];

        int i = left + 1;
        int j = right;

        while (true) {
            while (i <= j && (strings[i] + base).compareTo(base + strings[i]) <= 0) {
                i++;
            }

            while (i <= j && (strings[j] + base).compareTo(base + strings[j]) >= 0) {
                j--;
            }

            if (i > j) {
                break;
            }

            String temp = strings[i];
            strings[i] = strings[j];
            strings[j] = temp;
        }
        strings[left] = strings[j];
        strings[j] = base;

        quickSort(strings, left, j - 1);
        quickSort(strings, j + 1, right);
    }
}
