package com.xiaoling;

import com.xiaoling.common.TreeNode;
import com.xiaoling.leetcode.solution.Q106;

/**
 * @author xiaoling
 */
public class Main {

    public static void main(String[] args) {
        Q106 q = new Q106();

        TreeNode tree = q.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }
}
