package com.xiaoling;

import com.xiaoling.common.TreeNode;
import com.xiaoling.leetcode.offer.Offer34;

import java.util.List;

/**
 * @author xiaoling
 */
public class Main {

    public static void main(String[] args) {
        Offer34 q = new Offer34();

        TreeNode treeNode = new TreeNode(5,
                new TreeNode(4, new TreeNode(11,
                        new TreeNode(7),
                        new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(1)
                        )
                )
        );
        List<List<Integer>> result = q.pathSum(treeNode, 22);
        System.out.println(result);
    }
}
