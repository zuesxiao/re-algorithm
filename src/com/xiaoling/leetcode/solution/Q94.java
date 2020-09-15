package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoling
 */
public class Q94 {
    List<Integer> result = new LinkedList<>();

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                inorderTraversal(root.left);
            }

            result.add(root.val);

            if (root.right != null) {
                inorderTraversal(root.right);
            }
        }

        return result;
    }

    /**
     * 遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }

    /**
     * Morris 中序遍历
     * Morris 遍历算法整体步骤如下（假设当前遍历到的节点为 x）：
     * 1. 如果 x 无左孩子，先将 x 的值加入答案数组，再访问 x 的右孩子，即 x = x.right。
     * 2. 如果 x 有左孩子，则找到 x 左子树上最右的节点（即左子树中序遍历的最后一个节点，x 在中序遍历中的前驱节点），我们记为 predecessor。根据 predecessor 的右孩子是否为空，进行如下操作。
     * 1). 如果 predecessor 的右孩子为空，则将其右孩子指向 x，然后访问 x 的左孩子，即 x = x.left。
     * 2). 如果 predecessor 的右孩子不为空，则此时其右孩子指向 x，说明我们已经遍历完 x 的左子树，我们将 predecessor 的右孩子置空，将 x 的值加入答案数组，然后访问 x 的右孩子，即 x = x.right。
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                res.add(root.val);
                root = root.right;
            }
        }

        return res;
    }
}
