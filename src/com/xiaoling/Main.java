package com.xiaoling;

import com.xiaoling.common.TreeNode;
import com.xiaoling.leetcode.offer.Offer54;

/**
 * @author xiaoling
 */
public class Main {

    public static void main(String[] args) {
        Offer54 q = new Offer54();
        int c = q.kthLargest(new TreeNode(3,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(4)), 3);
        System.out.println(c);
    }
}
