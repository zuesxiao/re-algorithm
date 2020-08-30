package com.xiaoling.leetcode.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xiaoling
 */
public class Q118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows <= 0) {
            return result;
        }

        result.add(Collections.singletonList(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            row.add(1);

            List<Integer> prevRow = result.get(i - 1);

            for (int j = 1; j < i; j++) {
                row.add(j, prevRow.get(j) + prevRow.get(j - 1));
            }

            result.add(row);
        }

        return result;
    }
}
