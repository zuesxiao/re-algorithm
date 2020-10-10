package com.xiaoling.leetcode.solution;

import com.xiaoling.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author xiaoling
 */
public class Q142 {
    /**
     * Hash表算法，遍历列表节点，如果碰到已经访问过的节点，说明这个节点就是入环点，否则没有环
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        Set<ListNode> visited = new HashSet<>();
        ListNode p = head;

        while (p != null) {
            if (visited.contains(p)) {
                return p;
            } else {
                visited.add(p);
            }
            p = p.next;
        }

        return null;
    }

    /**
     * 快慢指针算法，如果存在环，快慢指针最终会相遇，
     * 设链表中环外部分的长度为 a。slow 指针进入环后，又走了 b 的距离与 fast 相遇。此时，fast 指针已经走完了环的 n 圈，因此它走过的总距离为 a+n(b+c)+b=a+(n+1)b+nc。
     * 根据题意，任意时刻，fast 指针走过的距离都为 slow 指针的 2 倍。因此，我们有
     * a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
     * 这个公式说明：从相遇点到入环点的距离加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离。
     * 因此，当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
     *
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;

            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (slow == fast) {
                ListNode out = head;
                while (out != slow) {
                    out = out.next;
                    slow = slow.next;
                }
                return out;
            }
        }

        return null;
    }
}
