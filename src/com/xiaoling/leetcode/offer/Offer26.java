package com.xiaoling.leetcode.offer;

import com.xiaoling.common.TreeNode;

/**
 * 剑指 Offer 26. 树的子结构
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 *
 * @author xiaoling
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }

        return isSub(A, B);
    }

    private boolean isSub(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        } else if (a == null) {
            return false;
        }

        if (a.val == b.val) {
            boolean fullSubLeft = isFullSub(a.left, b.left);
            boolean fullSubRight = isFullSub(a.right, b.right);

            if (fullSubLeft && fullSubRight) {
                return true;
            }
        }

        boolean isSubLeft = isSub(a.left, b);
        boolean isSubRight = isSub(a.right, b);

        return isSubLeft || isSubRight;
    }

    private boolean isFullSub(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        } else if (a == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        return isFullSub(a.left, b.left) && isFullSub(a.right, b.right);
    }
}
