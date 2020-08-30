package com.xiaoling.leetcode.solution;

import java.util.List;

/**
 * @author xiaoling
 */
public class Q120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int rowIndex = 1; rowIndex < triangle.size(); rowIndex++) {
            List<Integer> row = triangle.get(rowIndex);
            row.set(0, row.get(0) + triangle.get(rowIndex - 1).get(0));
            for (int colIndex = 1; colIndex < rowIndex; colIndex++) {
                row.set(colIndex, Math.min(row.get(colIndex) + triangle.get(rowIndex - 1).get(colIndex), row.get(colIndex) + triangle.get(rowIndex - 1).get(colIndex - 1)));
            }
            row.set(rowIndex, row.get(rowIndex) + triangle.get(rowIndex - 1).get(rowIndex - 1));
        }

        int distance = Integer.MAX_VALUE;
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        for (int index = 0; index < lastRow.size(); index++) {
            distance = Math.min(distance, lastRow.get(index));
        }
        return distance;
    }
}
