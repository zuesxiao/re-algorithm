package com.xiaoling.leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author xiaoling
 */
public class Q349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[nums1.length];
        int index = 0;
        for (int num : nums1) {
            if(map.containsKey(num)){
                result[index++] = num;
                map.remove(num);
            }
        }

        return Arrays.copyOfRange(result, 0, index);
    }
}
