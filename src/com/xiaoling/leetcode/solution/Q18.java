package com.xiaoling.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiaoling
 */
public class Q18 {
    boolean[] marks;
    List<Integer> temp;
    List<List<Integer>> res;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        marks = new boolean[nums.length];
        Arrays.fill(marks, false);
        temp = new ArrayList<>();
        res = new ArrayList<>();

        Arrays.sort(nums);

        sum(nums, target, 0);

        return res;
    }

    private void sum(int[] nums, int target, int start) {
        if (temp.size() == 4) {
            if (target == 0) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if(nums.length - start < 4 - temp.size()){
                return;
            }

            if((4 - temp.size()) * nums[i] > target){
                return;
            }

            if((4 - temp.size()) * nums[nums.length - 1] < target){
                return;
            }

            if (marks[i] || (i > 0 && nums[i] == nums[i - 1] && !marks[i - 1])) {
                continue;
            }

            marks[i] = true;
            temp.add(nums[i]);
            sum(nums, target - nums[i], i + 1);
            marks[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
