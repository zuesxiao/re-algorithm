package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q657 {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }

        int length = moves.length();

        if (length % 2 != 0) {
            return false;
        }

        int stepCol = 0, stepRow = 0;

        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'R') {
                stepRow++;
            }
            if (c == 'L') {
                stepRow--;
            }
            if (c == 'D') {
                stepCol++;
            }
            if (c == 'U') {
                stepCol--;
            }
        }

        return stepCol == 0 && stepRow == 0;
    }
}
