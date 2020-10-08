package com.xiaoling.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 834. 树中距离之和
 * https://leetcode-cn.com/problems/sum-of-distances-in-tree/
 *
 * @author xiaoling
 */
public class Q834 {
    int[][] matrix;
    List<List<Integer>> graph;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        matrix = new int[N][N];
        graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
            Arrays.fill(matrix[i], 0);
        }

        for (int i = 0; i < N; i++) {
            int[] edge = edges[i];
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] res = new int[N];

        for (int start = 0; start < N; start++) {
            for (int end = 0; end < N; end++) {
                res[start] += calculate(start, end);
            }
        }

        return res;
    }

    public int calculate(int start, int end) {
        if (start == end) {
            return 0;
        }

        if (matrix[start][end] != 0) {
            return matrix[start][end];
        }

        for(int node: graph.get(start)){
            if(node == end){
                return 1;
            }else {
                return 1 + calculate(node, end);
            }
        }

        return 0;
    }
}
