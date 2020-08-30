package com.xiaoling.leetcode.solution;

import java.util.Arrays;

/**
 * @author xiaoling
 */
public class Q785 {
    private int[] coloredNode;
    private boolean valid = true;
    private int UNCOLORED = 0;
    private int RED = 1;
    private int BLUE = 2;

    public boolean isBipartite(int[][] graph) {
        coloredNode = new int[graph.length];
        Arrays.fill(coloredNode, UNCOLORED);

        // for (int i = 0; i < graph.length; i++) {
        //     if (coloredNode[i] == UNCOLORED) {
        //         Queue<Integer> queue = new LinkedList<>();
        //         queue.offer(i);
        //         coloredNode[i] = RED;
        //         while (!queue.isEmpty()) {
        //             int node = queue.poll();
        //             int neighborColor = coloredNode[node] == RED ? BLUE : RED;
        //             for (int neighbor : graph[node]) {
        //                 if (coloredNode[neighbor] == UNCOLORED) {
        //                     coloredNode[neighbor] = neighborColor;
        //                     queue.offer(neighbor);
        //                 } else if(coloredNode[neighbor] != neighborColor) {
        //                     return false;
        //                 }
        //             }
        //         }
        //     }
        // }
        // return true;
        for(int i = 0; i < graph.length; i++){
            if(coloredNode[i] == UNCOLORED){
                dfs(i, RED, graph);
            }
        }
        return valid;
    }

    private void dfs(int node, int color, int[][] graph) {
        coloredNode[node] = color;
        int neighborColor = color == RED ? BLUE : RED;
        for (int neighbor : graph[node]) {
            if (coloredNode[neighbor] == UNCOLORED) {
                dfs(neighbor, neighborColor, graph);
                if (!valid) {
                    return;
                }
            } else if (coloredNode[neighbor] != neighborColor) {
                valid = false;
                return;
            }
        }
    }
}
