package com.xiaoling.leetcode.solution;

/**
 * 75. 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 *
 * @author xiaoling
 */
public class Q75 {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];

        for (int num : nums) {
            counts[num]++;
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < counts[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    public void sortColors1(int[] nums) {
        int length = nums.length;
        int pt = 0;

        for (int i = pt; i < length; i++) {
            if (nums[i] == 0) {
                int temp = nums[pt];
                nums[pt] = nums[i];
                nums[i] = temp;
                pt++;
            }
        }

        for (int i = pt; i < length; i++) {
            if (nums[i] == 1) {
                int temp = nums[pt];
                nums[pt] = nums[i];
                nums[i] = temp;
                pt++;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int length = nums.length;
        int p0 = 0;
        int p1 = 0;

        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;

                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                p0++;
                p1++;
            }
        }
    }

    public void sortColors3(int[] nums) {
        int length = nums.length;
        int p0 = 0;
        int p2 = length - 1;

        for (int i = 0; i < length; i++) {
            while (i < p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
            }
        }
    }
}
