package com.xiaoling.leetcode.solution;

import java.util.*;

/**
 * @author xiaoling
 */
public class Q332 {
    List<String> result;
    Map<String, PriorityQueue<String>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>(0);
        result = new ArrayList<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            if (!map.containsKey(from)) {
                map.put(from, new PriorityQueue<>());
            }

            map.get(from).add(to);
        }

        dfs("JFK");
        Collections.reverse(result);
        return result;
    }

    private void dfs(String start) {
        while (map.containsKey(start) && map.get(start).size() > 0) {
            String to = map.get(start).poll();
            dfs(to);
        }
        result.add(start);
    }
}
