package com.xiaoling;

import com.xiaoling.leetcode.offer.Offer12;

/**
 * @author xiaoling
 */
public class Main {

    public static void main(String[] args) {
        Offer12 q = new Offer12();

        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };


        System.out.println(q.exist(board, "ABCESEEEFS"));
    }
}
