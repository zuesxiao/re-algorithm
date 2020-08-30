package com.xiaoling.leetcode.solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author xiaoling
 */
public class Q491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Set<Integer> hashSet = new HashSet<>();

        if (nums == null || nums.length <= 1) {
            return result;
        }

        int total = (1 << nums.length);
        int mask = 0;
        while (mask < total) {
            List<Integer> list = isAscend(nums, mask);
            if (list != null) {
                int hash = getHash(list);
                if (!hashSet.contains(hash)) {
                    result.add(list);
                    hashSet.add(hash);
                }
            }
            mask++;
        }

        return result;
    }

    public int getHash(List<Integer> list) {
        int base = 263;
        int mod = (int) 1E9 + 7;
        int hashValue = 0;
        for (int x : list) {
            hashValue = hashValue * base % mod + (x + 101);
            hashValue %= mod;
        }
        return hashValue;
    }

    private List<Integer> isAscend(int[] nums, int mark) {
        List<Integer> result = new LinkedList<>();
        for (int num : nums) {
            if ((mark & 1) != 0) {
                result.add(num);
            }
            mark >>= 1;
        }

        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) > result.get(i + 1)) {
                return null;
            }
        }

        if (result.size() >= 2) {
            return result;
        }

        return null;
    }
}