package com.xiaoling;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void add(String value) {
        if (Objects.isNull(value)) {
            return;
        }

        TrieNode nextNode = root;
        for (int i = 0; i < value.length(); i++) {
            char character = value.charAt(i);
            if (!nextNode.next.containsKey(character)) {
                nextNode.next.put(character, new TrieNode());
            }
            nextNode = nextNode.next.get(character);
            nextNode.count++;
        }
        nextNode.end++;
    }

    public boolean find(String value) {
        if (Objects.isNull(value)) {
            return false;
        }

        TrieNode nextNode = root;
        for (int i = 0; i < value.length(); i++) {
            char character = value.charAt(i);

            if (!nextNode.next.containsKey(character)) {
                return false;
            }

            nextNode = nextNode.next.get(character);
            if (i == value.length() - 1 && nextNode.end > 0) {
                return true;
            }
        }

        return nextNode.end > 0;
    }

    public void delete(String value) {
        if (!find(value)) {
            return;
        }

        TrieNode nextNode = root;
        for (int i = 0; i < value.length(); i++) {
            char character = value.charAt(i);

            nextNode = nextNode.next.get(character);
            nextNode.count--;
        }
        nextNode.end--;
    }

    private static class TrieNode {
        public int end;
        public int count;
        public Map<Character, TrieNode> next;

        public TrieNode() {
            this.end = 0;
            this.count = 0;
            next = new HashMap<>();
        }
    }
}
