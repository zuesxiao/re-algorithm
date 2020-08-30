package com.xiaoling.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author xiaoling
 */
public class Q632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int size = nums.size();

        if (size == 1) {
            List<Integer> l = nums.get(0);

            if (l.isEmpty()) {
                return new int[0];
            } else {
                return new int[]{l.get(0), l.get(0)};
            }
        }

        int[] points = new int[size];
        Arrays.fill(points, 0);

        List<Integer> all = new ArrayList<>();

        while (true) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < size; i++) {
                List<Integer> list = nums.get(i);

                if (points[i] < list.size()) {
                    int currentValue = list.get(points[i]);
                    if (currentValue < minValue) {
                        minIndex = i;
                        minValue = currentValue;
                    }
                }
            }

            if (minIndex == -1) {
                break;
            } else {
                points[minIndex]++;
                all.add(minValue);
            }
        }

        int total = all.size();
        int left = 0, right = 0;
        int min = all.get(left), max = all.get(total - 1);

        while (right < total && left < total) {
            int leftValue = all.get(left), rightValue = all.get(right);
            if (isAllValid(leftValue, rightValue, nums)) {
                if (isSmaller(leftValue, rightValue, min, max)) {
                    min = leftValue;
                    max = rightValue;
                }
                left++;
            } else {
                right++;
            }
        }

        return new int[]{min, max};
    }

    private boolean isSmaller(int start1, int end1, int start2, int end2) {
        if (end1 - start1 > end2 - start2) {
            return false;
        } else if (end1 - start1 == end2 - start2) {
            return start1 < start2;
        } else {
            return true;
        }
    }

    private boolean isAllValid(int min, int max, List<List<Integer>> nums) {
        for (List<Integer> list : nums) {
            if (!isValid(min, max, list)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int min, int max, List<Integer> list) {
        int left = 0, right = list.size() - 1;

        if (list.get(0) > max || list.get(list.size() - 1) < min) {
            return false;
        }

        while (left <= right) {
            int middle = (right + left) / 2;

            int v = list.get(middle);

            if (v >= min && v <= max) {
                return true;
            }

            if (list.get(middle) > max) {
                right = middle - 1;
            }

            if (list.get(middle) < min) {
                left = middle + 1;
            }
        }

        return false;
    }
}
