package com.xiaoling.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * TODO
 *
 * @author xiaoling
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Map<Integer, Integer> pushSequence = new HashMap<>(pushed.length);
        for (int i = 0; i < pushed.length; i++) {
            pushSequence.put(pushed[i], i);
        }

        int firstPushSequence = 0;
        int currentSequence = Integer.MAX_VALUE;
        for (int j = 0; j < popped.length; j++) {
            int currentPushSequence = pushSequence.get(popped[j]);
            if (firstPushSequence == j) {
                firstPushSequence = currentPushSequence;
            } else {
                if (currentPushSequence < firstPushSequence && currentPushSequence >= currentSequence) {
                    return false;
                } else {
                    currentSequence = currentPushSequence;
                }
            }
        }

        return true;
    }
}
