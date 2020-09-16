package com.xiaoling;

import com.xiaoling.common.TreeNode;
import com.xiaoling.leetcode.offer.Offer26;

/**
 * @author xiaoling
 */
public class Main {

    public static void main(String[] args) {
        Offer26 q = new Offer26();

        TreeNode a = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                new TreeNode(9)),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));

        TreeNode a1 = new TreeNode(3,
                null,
                new TreeNode(2));

        TreeNode b = new TreeNode(4,
                new TreeNode(8),
                new TreeNode(9));

        TreeNode b1 = new TreeNode(3,
                null,
                new TreeNode(2, new TreeNode(2), null));

        System.out.println(q.isSubStructure(a, b));
    }
}
