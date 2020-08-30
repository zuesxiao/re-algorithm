package com.xiaoling.leetcode.solution;

import com.xiaoling.common.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoling
 */
public class Q133 {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node copy = new Node(node.val, new ArrayList<>());
        map.put(node, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }

        return copy;
    }
}
