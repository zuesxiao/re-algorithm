package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

/**
 * @author xiaoling
 */
public class Q968 {
    /**
     * 为了表述方便，我们约定：如果某棵树的所有节点都被监控，则称该树被「覆盖」。
     * 假设当前节点为root，其左右孩子为left,right。如果要覆盖以root为根的树，有两种情况：
     * 1. 若在root处安放摄像头，则孩子left,right 一定也会被监控到。此时，只需要保证left 的两棵子树被覆盖，同时保证right 的两棵子树也被覆盖即可。
     * 2. 否则， 如果root处不安放摄像头，则除了覆盖root的两棵子树之外，孩子left,right之一必须要安装摄像头，从而保证root会被监控到。
     * 根据上面的讨论，能够分析出，对于每个节点root ，需要维护三种类型的状态：
     * 状态 a：root必须放置摄像头的情况下，覆盖整棵树需要的摄像头数目。
     * 状态 b：覆盖整棵树需要的摄像头数目，无论root是否放置摄像头。
     * 状态 c：覆盖两棵子树需要的摄像头数目，无论节点root本身是否被监控到。
     * 根据它们的定义，一定有a ≥ b ≥ c。
     * 对于节点root 而言，设其左右孩子left,right 对应的状态变量分别为(la,lb,lc) 以及(ra,rb,rc)。根据一开始的讨论，我们已经得到了求解 a,b 的过程：
     * a=lc + rc + 1
     * b=min(a, min(la + rb, ra + lb))
     * 对于c而言，要保证两棵子树被完全覆盖，要么root处放置一个摄像头，需要的摄像头数目为a；要么root处不放置摄像头，此时两棵子树分别保证自己被覆盖，需要的摄像头数目为lb + rb。
     * 需要额外注意的是，对于root而言，如果其某个孩子为空，则不能通过在该孩子处放置摄像头的方式，监控到当前节点。因此，该孩子对应的变量a应当返回一个大整数，用于标识不可能的情形。
     * 最终，根节点的状态变量 bb 即为要求出的答案。
     *
     * @param root
     * @return
     */
    public int minCameraCover(TreeNode root) {
        int[] res = dfs(root);
        return res[1];
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }

        int[] leftRes = dfs(node.left);
        int[] rightRes = dfs(node.right);

        int[] res = new int[3];

        res[0] = leftRes[2] + rightRes[2] + 1;
        res[1] = Math.min(res[0], Math.min(leftRes[0] + rightRes[1], leftRes[1] + rightRes[0]));
        res[2] = Math.min(res[0], leftRes[1] + rightRes[1]);

        return res;
    }
}
