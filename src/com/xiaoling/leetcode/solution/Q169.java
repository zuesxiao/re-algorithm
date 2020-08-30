package com.xiaoling.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoling
 */
public class Q169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int result = 0;
        int max = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            int v = map.get(key);
            if (v > max) {
                result = key;
                max = v;
            }
        }
        return result;
    }
}
