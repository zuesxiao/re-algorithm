package com.xiaoling.leetcode.solution;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author xiaoling
 */
public class Q374 {
    /**
     * 方法一：堆
     * 首先遍历整个数组，并使用哈希表记录每个数字出现的次数，并形成一个「出现次数数组」。找出原数组的前 kk 个高频元素，就相当于找出「出现次数数组」的前 kk 大的值。
     * 在这里，我们可以利用堆的思想：建立一个小顶堆，然后遍历「出现次数数组」：
     * 如果堆的元素个数小于 kk，就可以直接插入堆中。
     * 如果堆的元素个数等于 kk，则检查堆顶与当前出现次数的大小。如果堆顶更大，说明至少有 kk 个数字的出现次数比当前值大，故舍弃当前值；否则，就弹出堆顶，并将当前值插入堆中。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (Integer key : map.keySet()) {
            int count = map.get(key);
            if (priorityQueue.size() < k) {
                priorityQueue.offer(new int[]{key, count});
            } else {
                int[] top = priorityQueue.peek();
                if (count > top[1]) {
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{key, count});
                }
            }
        }

        int[] res = new int[k];
        while (!priorityQueue.isEmpty()) {
            res[priorityQueue.size() - 1] = priorityQueue.poll()[0];
        }
        return res;
    }


    /**
     * 方法二：基于快速排序
     * 思路与算法
     * 我们可以使用基于快速排序的方法，求出「出现次数数组」的前 kk 大的值。
     * 在对数组 \textit{arr}[l \ldots r]arr[l…r] 做快速排序的过程中，我们首先将数组划分为两个部分 \textit{arr}[i \ldots q-1]arr[i…q−1] 与 \textit{arr}[q+1 \ldots j]arr[q+1…j]，并使得 \textit{arr}[i \ldots q-1]arr[i…q−1] 中的每一个值都不超过 \textit{arr}[q]arr[q]，且 \textit{arr}[q+1 \ldots j]arr[q+1…j] 中的每一个值都大于 \textit{arr}[q]arr[q]。
     * 于是，我们根据 kk 与左侧子数组 \textit{arr}[i \ldots q-1]arr[i…q−1] 的长度（为 q-iq−i）的大小关系：
     * 如果 k \le q-ik≤q−i，则数组 \textit{arr}[l \ldots r]arr[l…r] 前 kk 大的值，就等于子数组 \textit{arr}[i \ldots q-1]arr[i…q−1] 前 kk 大的值。
     * 否则，数组 \textit{arr}[l \ldots r]arr[l…r] 前 kk 大的值，就等于左侧子数组全部元素，加上右侧子数组 \textit{arr}[q+1 \ldots j]arr[q+1…j] 中前 k - (q - i)k−(q−i) 大的值。s
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        int[] ret = new int[k];
        qsort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }
}
